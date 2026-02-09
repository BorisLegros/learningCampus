import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
  ],
  server: {
    proxy: {
      '/api': 'http://backend:8080'
    }
  },
  // Configuration pour la production
  base: '/',  // Important pour que les assets soient chargés correctement
  build: {
    outDir: 'dist',  // Dossier de sortie (utilisé dans le Dockerfile)
  },
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
})
