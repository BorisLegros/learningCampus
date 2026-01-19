<template>

  <div class="navbar">
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
  index.value = key
}
</script>

<style scoped>

.navbar {
  display : flex;
  //border : solid 1px;
  justify-content: space-around;
  gap: 30px;
  padding: 50px;
}

.navbar button {
  flex: 1;
  border-radius: 10% 10% 100% 100%;
  height: 35px;
  cursor: pointer;
  transition: background 0.2s;
}
.button-bar button:hover {
  background: #f0f0f0;
}
</style>
