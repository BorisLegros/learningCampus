<template>
  <div class="table_border">
    <table>
      <thead>
        <tr>
          <th v-for="header in headers" :key="'header_'+header.key">
            <div class="header">
              <strong> {{ header.title }} </strong>
            </div>
          </th>
          <th class="th_cross">   </th>
        </tr>
        <tr style="height: 0.7rem;">
          <th colspan="100" style="border: none; padding: 0;"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in data" :key="'data_'+item.id">
          <td v-for="(value, key) in item" :key="item.id+'_'+key" v-show="containHeader(key)">
            {{ value }}
          </td>
          <th @click="deleteRow(item.id)"> x </th>
        </tr>
     </tbody>
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
  readonly entity: string,
  readonly headers: iHead[], // [{title: String, key: String}, ...] key is attribut name
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

    console.log(data.value)
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


.header {
  border: 1px solid black;
  padding-inline: 1rem;
}

.th_cross {
  width: 2rem;
}

.table_border {
  border: solid grey 2px;
  border-radius: 25px;
  padding: 1rem;
  width: fit-content;
}

table {
  border-collapse: collapse;
}

thead {
  border-bottom: 2px solid grey;
}

td {
  padding-inline: 1rem;
}

tbody tr:first-child th {
  padding-top: 1rem; /* ← Ajustez cette valeur */
}

</style>
