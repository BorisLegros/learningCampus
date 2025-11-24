// config
const API_BASE_URL = '/api';
const DEFAULT_HEADERS = {
  'Content-Type': 'application/json'
};

// gere les API error
class ApiError extends Error {
  constructor(message: string, public status: number, public data?: any) {
    super(message);
    this.name = 'ApiError';
  }
}

// requete fetch
async function fetchApi<T>(endpoint: string, options: RequestInit = {}): Promise<T> {
  const url = `${API_BASE_URL}${endpoint}`;
  const config: RequestInit = {
    ...options,
    headers: {
      ...DEFAULT_HEADERS,
      ...options.headers,
    },
  };

  try {
    // lancement de la requete
    const response = await fetch(url, config);

    // verification de la reponse
    if (!response.ok) {
      const errorData = await response.json().catch(() => null);
      throw new ApiError(
        errorData?.message || `Http error: ${response.status}`,
        response.status,
        errorData
      );
    }

    return await response.json();
  } catch (error) {
    if(error instanceof ApiError) {
      throw error;
    }

    // network error
    console.error('Network Error : ', error);
    throw new ApiError(
      'Connexion to serve fail',
      0,
      error
    );
  }
}

// Service API
const api = {
  async getHelloWorld(): Promise<string> {
    return fetchApi<string>('/helloworld', {
      method: 'GET',
    });
  }
}

export default api
export { ApiError }
