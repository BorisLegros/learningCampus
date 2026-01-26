<template>
  <div class="login-container">
    <form @submit.prevent="handleLogin" class="login-form">
      <h2>Connexion</h2>

      <div class="form-group">
        <label for="username">Nom d'utilisateur</label>
        <input
          id="username"
          v-model="username"
          type="text"
          required
          :disabled="loading"
        />
      </div>

      <div class="form-group">
        <label for="password">Mot de passe</label>
        <input
          id="password"
          v-model="password"
          type="password"
          required
          :disabled="loading"
        />
      </div>

      <div v-if="error" class="error">{{ error }}</div>

      <button type="submit" :disabled="loading">
        {{ loading ? 'Connexion...' : 'Se connecter' }}
      </button>
    </form>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { setToken, clearAuth } from '@/services/auth';
import api from '@/services/api';

// SIGNAL
const emits = defineEmits([
  "connexionOk"
])

// STATE
const username = ref<string>('');
const password = ref<string>('');
const error = ref<string>('');
const loading = ref<boolean>(false);

// METHOD
async function handleLogin(): Promise<void> {
  error.value = '';
  loading.value = true;

  try {
    const response = await api.request<{ token: string }>('/public/login', 'POST', {
      username: username.value,
      password: password.value
    });

    setToken(response.token);
    emits("connexionOk")
  } catch (err) {
    clearAuth();
    error.value = 'Identifiants incorrects';
  } finally {
    loading.value = false;
  }
}
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

.login-form {
  width: 100%;
  max-width: 400px;
  padding: 2rem;
  border: 1px solid #ddd;
  border-radius: 8px;
}

.form-group {
  margin-bottom: 1rem;
}

label {
  display: block;
  margin-bottom: 0.5rem;
}

input {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ddd;
  border-radius: 4px;
}

button {
  width: 100%;
  padding: 0.75rem;
  background: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

.error {
  color: red;
  margin-bottom: 1rem;
}
</style>
