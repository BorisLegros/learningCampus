
<template>
  <hello-world-component/>

  <login-component v-if="!isConnected"
                   @connexion-ok="isConnected = true"
  />


  <tab-component v-else
    :tabs="tabs">

    <template #collab>
      <div class="index">
        <collaborateur-index :headers="collaborateurHeaders"/>
        <collaborateur-create/>
      </div>
      <hr/>
    </template>

    <template #fonction>
      <div class="index">
        <fonction-index :headers="fonctionHeaders"/>
        <fonction-create/>
      </div>
      <hr/>
    </template>

    <template #store>
      <div class="index">
        <restaurant-index :headers="restaurantHeaders" @clickRow="handleClickRowRestaurant"/>
        <Restaurant-create/>
      </div>
      <hr/>
      <div class="index">
        <affectation-index ref="affectationRestaurant"/>
      </div>
    </template>

    <template #affectation>
      <div class="index">
        <affectation-index/>
        <affectation-create/>
      </div>
      <hr/>
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
import FonctionCreate from "@/components/fonction/FonctionCreate.vue";
import AffectationIndex from "@/components/affectation/AffectationIndex.vue";
import AffectationCreate from "@/components/affectation/AffectationCreate.vue";

import TabComponent from "@/components/generic/TabComponent.vue"
import LoginComponent from "@/components/LoginComponent.vue";

// COMPONENT
const affectationRestaurant = ref(null)

// STATE
const isConnected = ref(false)

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

function handleClickRowRestaurant(row: object) {

  console.log(typeof row)
  console.log(row)

  affectationRestaurant.value.handleAddFilter(row)
}
</script>

<style scoped>
.index {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  gap: 2rem;
}
</style>
