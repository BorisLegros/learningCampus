
<template>
  <hello-world-component/>

  <tab-component
    :tabs="tabs">

    <template #collab>
      <collaborateur-index :headers="collaborateurHeaders"/>
      <collaborateur-create/>
    </template>

    <template #fonction>
      <fonction-index :headers="fonctionHeaders"/>
      <fonction-create/>
    </template>

    <template #store>
      <restaurant-index :headers="restaurantHeaders"/>
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
const tabs = ref([
  {title: "Collaborateur", key: "collab"},
  {title: "Fonction", key: "fonction"},
  {title: "Restaurant", key: "store"}
])

const fonctionHeaders = ref ([
  {title: "Metier", key: "label"}
])

const restaurantHeaders = ref ([
  {title: "Nom", key: "name"},
  {title: "Adresse", key: "address"},
  {title: "Code Postal", key: "zipcode"},
  {title: "Ville", key: "city"}
])

const collaborateurHeaders = ref ([
  {title: "Prenom", key: "firstname"},
  {title: "Nom", key: "lastname"},
  {title: "Email", key: "email"},
  {title: "Embauche le", key: "dateEmbauche"},
  {title: "Admin ?", key: "isAdmin"}
])
</script>

<style scoped></style>
