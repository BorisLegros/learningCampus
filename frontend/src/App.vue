
<template>
  <hello-world-component/>

  <restaurant-index/>
  <RestaurantCreate/>

  <fonction-index/>
  <fonction-create/>

  <collaborateur-index/>
  <collaborateur-create/>
</template>

<script setup lang="ts">
import HelloWorldComponent from './components/HelloWorldComponent.vue';
import RestaurantIndex from "@/components/restaurant/RestaurantIndex.vue";
import RestaurantCreate from "@/components/restaurant/RestaurantCreate.vue";
import CollaborateurIndex from "@/components/collaborateur/CollaborateurIndex.vue";
import CollaborateurCreate from "@/components/collaborateur/CollaborateurCreate.vue";
import FonctionIndex from "@/components/fonction/FonctionIndex.vue";
import FonctionCreate from "@/components/fonction/fonctionCreate.vue";
</script>

<style scoped></style>
