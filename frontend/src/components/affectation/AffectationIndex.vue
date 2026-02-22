<template>
<index-component
  ref="component"
  entity="/affectation"
  :headers="affectationHeaders"
/>
</template>

<script setup lang="ts">

import IndexComponent from "@/components/generic/IndexComponent.vue";
import {ref} from "vue";

const affectationHeaders = ref ([
  {title: "Collaborateur", key: "collaborateur"},
  {title: "Restaurant", key: "restaurant"},
  {title: "Poste", key: "poste"},
  {title: "Date de debut", key: "dateDebut"},
  {title: "Date de fin", key: "dateFin"}
])

const component = ref(null)
function handleAddFilter (data: object) {
  component.value.handleAddFilter({key: "restaurant", value: data.name})
}
defineExpose({handleAddFilter})
</script>

<style scoped>

</style>
