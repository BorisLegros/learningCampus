<template>
  <div>
    <table>
      <tr>
        <th v-for="header in headers" :key="'header_'+header.key" class="header"> <strong> {{ header.title }} </strong></th>
      </tr>
      <tr v-for="item in data" :key="'data_'+item.id" class="line">
        <th v-for="(value, key) in item" :key="item.id+'_'+key" v-show="containHeader(key)" class="attribute">
          {{ value }}
        </th>
        <th @click="deleteRow(item.id)"> x </th>
      </tr>
    </table>
  </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue"
import api, {ApiError} from "@/services/api.ts";

//TYPE
interface iHead {
  title: string
  key: string
}

interface iData {
  key: string
  value: never
}

// PROPS
const props = defineProps<{
  entity: string,
  headers: iHead[], // [{title: String, key: String}, ...] key is attribut name
}>()

// ATTRIBUTS
const data = ref<string>('');
const error = ref<string | null>(null);
const loading = ref<boolean>(false);

// METHOD
const containHeader = (key: string) => {
  return props.headers.some(head => head.key === key)
}

const deleteRow = async (id: number) => {
  console.log(id)
  loading.value = true;
  error.value = null;

  try {
    data.value = await api.request<string>(props.entity+'/'+id, 'DELETE');
  } catch (err) {
    if (err instanceof ApiError) {
      error.value = `Error ${err.status} : ${err.message}`;
    } else {
      error.value = 'Unknow error';
    }
    console.log(error.value)
  } finally {
    loading.value = false;
  }

}

const fetchData = async (): Promise<void> => {
  loading.value = true;
  error.value = null;

  try {
    data.value = await api.request<string>(props.entity, 'GET');
  } catch (err) {
    if (err instanceof ApiError) {
      error.value = `Error ${err.status} : ${err.message}`;
    } else {
      error.value = 'Unknow error';
    }
    console.log(error.value)
  } finally {
    loading.value = false;
  }
}

// LIFECYCLE
onMounted(() => {
  fetchData();
})
</script>

<style scoped>
.attribute {
  margin-right: 3rem;
  margin-bottom: 5rem;

}

.header {
  border: 1px solid black;
  padding-inline: 2rem;
}

.line {
  border: 1px solid black;
  padding-block: 5rem;
}
</style>
