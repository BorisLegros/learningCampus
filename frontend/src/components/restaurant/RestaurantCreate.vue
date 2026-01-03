<template>
  <create-component entity="/restaurant" :fields="fields"/>
</template>

<script setup lang="ts">

import CreateComponent from "@/components/generic/CreateComponent.vue";

const fields = [
  {key: 'name', type: 'text', label: 'Name : '},
  {key: 'address', type: 'text', label: 'Address : '},
  {key: 'zipcode', type: 'text', label: 'Zipcode : '},
  {key: 'city', type:'text', label: 'City : '}
]

</script>

<style scoped>

</style>
