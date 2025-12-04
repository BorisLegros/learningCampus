<template>
  <h1>{{ message }}</h1>
</template>


<script setup lang="ts">
import {onMounted, ref} from 'vue';
import api, {ApiError} from '@/services/api';

// ATTRIBUTS
const message = ref<string>('');
const error = ref<string | null>(null);
const loading = ref<boolean>(false);

// METHODS
const fetchMessage = async (): Promise<void> => {
  loading.value = true;
  error.value = null;
  try {
    const data = await api.getHelloWorld();
    message.value = data.message;
  } catch (err) {
    if (err instanceof ApiError) {
      error.value = `Error ${err.status} : ${err.message}`;
    } else {
      error.value = 'Unknow error';
    }
  } finally {
    loading.value = false;
  }
}
// LIFECYCLE
onMounted(() => {
  fetchMessage();
});
</script>
