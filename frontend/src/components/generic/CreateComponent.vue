<template>
  <form @submit.prevent="handleSubmit">
    <div v-for="field in fields" :key="field.key" class="form-group">
      <label :for="field.key">{{ field.label || field.key }}</label>
      <select v-if="field.type === 'select'">
        <option v-for="option in field.options" :value=option.value>{{ option.text }}</option>
      </select>
      <input v-else
        :id="field.key"
        v-model="formData[field.key]"
        :type="field.type || 'text'"
      />
    </div>
    <button type="submit">Create</button>
  </form>
</template>

<script setup lang="ts">
import {reactive, ref} from "vue";
import api, {ApiError} from "@/services/api.ts";

const props = defineProps({
  fields: {
    type: Array, // ex: [{ name: 'email', type: 'email', label: 'Email' }]
    required: true
  },
  entity: {
    type: String,
    required: true
  }
});

// STATE
const formData = reactive(
  Object.fromEntries(
    props.fields.map(field => [field, ''])
  )
);
const error = ref<string | null>(null)
const loading = ref<boolean>(false)

// METHOD
const handleSubmit = async (event: Event) => {
  event.preventDefault()

  loading.value = true;
  error.value = null;

  console.log(formData)

  try {
    await api.request<string>(props.entity, 'POST', formData)
  } catch (err) {
    if (err instanceof ApiError) {
      error.value = `Error ${err.status} : ${err.message}`;
    } else {
      error.value = 'Unknow error';
    }
    console.log(error.value)
  } finally {
    loading.value = false;
  }
}
</script>

<style scoped>

</style>
