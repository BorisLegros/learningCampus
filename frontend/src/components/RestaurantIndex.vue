<template>
<div>
  <li v-for="item in restaurants">
    {{ item.name }}
    {{ item.adress }}
    {{ item.zipcode }}
    {{ item.city }}
  </li>
</div>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import api, {ApiError} from '@/services/api';


// ATTRIBUTS
const restaurants = ref<string>('');
const error = ref<string | null>(null);
const loading = ref<boolean>(false);

// METHODS
const fetchMessage = async (): Promise<void> => {
  loading.value = true;
  error.value = null;
  try {
    console.log("aaaa")
    const data = await api.getRestaurant();
    restaurants.value = data;
  console.log("eeee")
  console.log(data)
  } catch (err) {
    if (err instanceof ApiError) {
      error.value = `Error ${err.status} : ${err.message}`;
    } else {
      error.value = 'Unknow error';
    }
  } finally {
    loading.value = false;
    console.log(restaurants.value)
  }
}

// LIFECYLCE
onMounted(() => {
  fetchMessage()
})
</script>

<style scoped>

</style>
