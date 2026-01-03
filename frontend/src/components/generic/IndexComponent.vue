<template>
  <div>
    <li v-for="item in data" :key="item.id">
      <span class="attribute"
            v-for="(value, key) in item" :key="key" v-show="key !== 'id'">
      <strong>{{ key }}:</strong> {{ value }} </span>
    </li>
  </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue"
import api, {ApiError} from "@/services/api.ts";

// PROPS
const props = defineProps({
  entity: {
    type: String,
    required: true
  }
})

// ATTRIBUTS
const data = ref<string>('');
const error = ref<string | null>(null);
const loading = ref<boolean>(false);

// METHOD
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
}
</style>
