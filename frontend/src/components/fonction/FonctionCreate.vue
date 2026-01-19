<template>
  <create-component entity="/fonction" :fields="fields"/>
</template>

<script setup lang="ts">

import CreateComponent from "@/components/generic/CreateComponent.vue";

const fields = [
  {key: 'label', type: 'text', label:'Label : '}
]
</script>

<style scoped>

</style>
