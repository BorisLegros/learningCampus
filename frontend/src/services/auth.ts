let authToken: string | null = null;

export function setToken(token: string): void {
  authToken = token;
}

export function clearAuth(): void {
  authToken = null;
}

export function getAuthHeader(): Record<string, string> {
  return authToken ? { 'Authorization': `Bearer ${authToken}` } : {};
}

export function isAuthenticated(): boolean {
  return authToken !== null;
}

export function getToken(): string | null {
  return authToken;
}







// avec stockage du token
/*
const TOKEN_KEY = 'jwt_token';

let authToken: string | null = localStorage.getItem(TOKEN_KEY);

export function setToken(token: string): void {
  authToken = token;
  localStorage.setItem(TOKEN_KEY, token);
}

export function clearAuth(): void {
  authToken = null;
  localStorage.removeItem(TOKEN_KEY);
}

export function getAuthHeader(): Record<string, string> {
  return authToken ? { 'Authorization': `Bearer ${authToken}` } : {};
}

export function isAuthenticated(): boolean {
  return authToken !== null;
}

export function getToken(): string | null {
  return authToken;
}
 */
