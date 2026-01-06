<template>

  <div>
    <button v-for="item in tabs" :key="item.key" @click="triggerBtnTab(item.key)">
      {{ item.title }}
    </button>
  </div>

  <div>
    <slot :name="index"></slot>
  </div>
<!--  <slot v-for="item in tabs" :name="item.key" v-if="index === item.key"></slot>-->

</template>

<script setup lang="ts">
import {ref} from "vue";


// PROPS

const props = defineProps({
  tabs: {
    type: Array, // [{title: String, key: String}, ...]
    required: true
  }
})

// STATE
const index = ref(props.tabs[0])

// METHOD
const triggerBtnTab = (key: string) => {
  console.log(key)
  index.value = key
}
</script>

<style scoped>

</style>
