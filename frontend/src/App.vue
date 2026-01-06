
<template>
<!--  <hello-world-component/>-->







  <tab-component
    :tabs="headers">

    <template #collab>
      <collaborateur-index/>
      <collaborateur-create/>
    </template>

    <template #fonction>
      <fonction-index/>
      <fonction-create/>
    </template>

    <template #store>
      <restaurant-index/>
      <RestaurantCreate/>
    </template>
  </tab-component>



</template>

<script setup lang="ts">
import {ref} from "vue";

import HelloWorldComponent from './components/HelloWorldComponent.vue';
import RestaurantIndex from "@/components/restaurant/RestaurantIndex.vue";
import RestaurantCreate from "@/components/restaurant/RestaurantCreate.vue";
import CollaborateurIndex from "@/components/collaborateur/CollaborateurIndex.vue";
import CollaborateurCreate from "@/components/collaborateur/CollaborateurCreate.vue";
import FonctionIndex from "@/components/fonction/FonctionIndex.vue";
import FonctionCreate from "@/components/fonction/fonctionCreate.vue";


import TabComponent from "@/components/generic/TabComponent.vue"

// STATE
const headers = ref([
  {title: "Collaborateur", key: "collab"},
  {title: "Fonction", key: "fonction"},
  {title: "Restaurant", key: "store"}
])
</script>

<style scoped></style>
