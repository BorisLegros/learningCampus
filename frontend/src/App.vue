<script setup lang="ts">
import HelloWorldComponent from './components/HelloWorldComponent.vue';
import RestaurantIndex from "@/components/RestaurantIndex.vue";
import RestaurantCreate from "@/components/RestaurantCreate.vue";
</script>

<template>
  <hello-world-component/>
  <restaurant-index/>

  <RestaurantCreate/>
</template>

<style scoped></style>
