// composables/useRefresh.js
import { ref } from 'vue'

const refreshTrigger = ref(0)

export function useRefresh() {
  const triggerRefresh = () => {
    refreshTrigger.value++
  }

  return { refreshTrigger, triggerRefresh }
}
