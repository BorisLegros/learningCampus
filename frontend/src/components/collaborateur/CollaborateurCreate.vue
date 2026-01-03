<template>
<create-component
  :fields="fields"
  entity="/collaborateur"
/>
</template>

<script setup lang="ts">

// COMPUTED
import {computed} from "vue";
import CreateComponent from "@/components/generic/CreateComponent.vue";

const fields = computed(() => [
  {key: 'firstname', type: 'text', label: 'Firstname : '},
  {key: 'lastname', type: 'text', label: 'Lastname : '},
  {key: 'email', type: 'email', label: 'Email : '},
  {key: 'dateEmbauche', type:'date', label: 'Date : '},
  {key: 'isAdmin', type:'checkbox', label: 'Admin ? '},
  {key: 'pwd', type: 'password', label: 'Password : '}
])
</script>

<style scoped>

</style>
