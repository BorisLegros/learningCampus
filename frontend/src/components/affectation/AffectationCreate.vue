<template>
<create-component
  :fields="fields"
  entity="/affectation"
/>
</template>

<script setup lang="ts">

import {computed, ref, onMounted} from "vue";
import CreateComponent from "@/components/generic/CreateComponent.vue";
import api, {ApiError} from "@/services/api.ts";


// COMPUTED
const collabOptions = ref([{value: 'a', text: 'a'}, {value: 'a', text: 'a'}, {value: 'a', text: 'a'}])
const restoOptions =  ref([{value: 'a', text: 'a'}, {value: 'a', text: 'a'}, {value: 'a', text: 'a'}])
const posteOptions =  ref([{value: 'a', text: 'a'}, {value: 'a', text: 'a'}, {value: 'a', text: 'a'}])

const fields = computed(() => [
  {key: 'collaborateur', type: 'select', label: 'Collaborateur : ', options: collabOptions.value},
  {key: 'restaurant', type: 'select', label: 'Restaurant : ', options: restoOptions.value},
  {key: 'poste', type: 'select', label: 'Poste : ', options: posteOptions.value},
])

// METHOD
const fetchData = async (): Promise<void> => {
  try {
    collabOptions.value = await api.request<string>("/collaborateur/selectList", 'GET');
    restoOptions.value = await api.request<string>("/restaurant/selectList", 'GET');
    posteOptions.value = await api.request<string>("/fonction/selectList", 'GET');
  } catch (err) {
     if (err instanceof ApiError) {
       error.value = `Error ${err.status} : ${err.message}`;
     } else {
       error.value = 'Unknow error';
     }
     console.log(error.value)
  }
}

// LIFECYCLE
onMounted(() => {
  fetchData()
})
</script>

<style scoped>

</style>
