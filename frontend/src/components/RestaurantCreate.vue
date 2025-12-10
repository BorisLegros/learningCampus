<script setup lang="ts">
import {ref} from "vue";
import api, {ApiError} from '@/services/api';

// STATE
const error = ref<string | null>(null)
const loading = ref<boolean>(false)

// ATTRIBUT
const restaurant = {
  name: "qdfsqf",
  adress: "fqsfbgsd",
  zipcode: "31500",
  city: "gsdgsgs"
}

// METHOD

async function handleSubmit(event: Event) {
  event.preventDefault();

  // console.log(restaurant)
  loading.value = true;
  error.value = null;
  try {
    const nvRestaurant = await api.request<string>('/restaurant', 'POST', restaurant);
    // console.log("fsldnfdsfkls")
    // console.log(nvRestaurant)
  } catch (err) {
    if (err instanceof ApiError) {
      error.value = `Error ${err.status} : ${err.message}`;
      console.error(error.value)
    } else {
      error.value = 'Unknow error';
    }
  } finally {
    loading.value = false;
  }
}


</script>

<template>
  <form @submit="handleSubmit">
    <div>
      <label>NOM : </label>
      <input type="text" v-model="restaurant.name" required>
    </div>
    <div>
      <label>ADRESSE : </label>
      <input type="text" v-model="restaurant.adress" required>
    </div>
    <div>
      <label>CODE POSTAL : </label>
      <input type="text" v-model="restaurant.zipcode" required>
    </div>
    <div>
      <label>VILLE : </label>
      <input type="text" v-model="restaurant.city" required>
    </div>
    <button  type="submit">CREER</button>
<!--    <button  @click="postRestaurant">CREER</button>-->
  </form>
</template>

<style scoped>

</style>
