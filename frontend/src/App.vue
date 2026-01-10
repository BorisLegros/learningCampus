
<template>
  <hello-world-component/>

  <tab-component
    :tabs="tabs">

    <template #collab>
      <collaborateur-index :headers="collaborateurHeaders"/>
          <hr>
      <collaborateur-create/>
    </template>

    <template #fonction>
      <fonction-index :headers="fonctionHeaders"/>
          <hr>
      <fonction-create/>
    </template>

    <template #store>
      <restaurant-index :headers="restaurantHeaders"/>
          <hr>
      <Restaurant-create/>
    </template>

    <template #affectation>
      <affectation-create/>
          <hr>
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
import AffectationIndex from "@/components/affectation/AffectationIndex.vue";
import AffectationCreate from "@/components/affectation/AffectationCreate.vue";

import TabComponent from "@/components/generic/TabComponent.vue"

// STATE
const tabs = ref([
  {title: "Collaborateur", key: "collab"},
  {title: "Fonction", key: "fonction"},
  {title: "Restaurant", key: "store"},
  {title: "Affectation", key: "affectation"}
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

const affectationHeaders = ref ([
  {title: "Collaborateur", key: "collaborateur"},
  {title: "Restaurant", key: "restaurant"},
  {title: "Poste", key: "poste"},
  {title: "Date de debut", key: "dateDebut"},
  {title: "Date de fin", key: "dateFin"}
])
</script>

<style scoped></style>
