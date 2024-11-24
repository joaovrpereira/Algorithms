function merge(A, left, mid, right) {
  const n_first = mid - left + 1;
  const n_second = right - mid;

  const L = new Array(n_first);
  const R = new Array(n_second);

  for (let i = 0; i < n_first; i++) {
    L[i] = A[left + i];
  }
  for (let j = 0; j < n_second; j++) {
    R[j] = A[mid + 1 + j];
  }

  let i = 0,
    j = 0;
  let k = left;
  while (i < n_first && j < n_second) {
    if (L[i] <= R[j]) {
      A[k] = L[i];
      i++;
    } else {
      A[k] = R[j];
      j++;
    }
    k++;
  }
  while (i < n_first) {
    A[k] = L[i];
    i++;
    k++;
  }

  while (j < n_second) {
    A[k] = R[j];
    j++;
    k++;
  }
}

function mergeSort(A, left, right) {
  //Caso base: somente um elemento
  if (left >= right) {
    return;
  }
  const mid = Math.floor(left + (right - left) / 2);
  mergeSort(A, left, mid);
  mergeSort(A, mid + 1, right);
  merge(A, left, mid, right);
}

function imprimeLista(A) {
  console.log(A.join(" "));
}

const A = [8, 1, 2, 4, 6, 7, 9, 10, 2, 5, 7];
imprimeLista(A);

//Utilizando .sort de Array.prototype
console.log(A.sort());

mergeSort(A, 0, A.length - 1);
imprimeLista(A);
