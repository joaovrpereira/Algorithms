//Ordenação em tempo linear O(n)
function countingSort(A,k) {
  const C = new Array(k+1);
  const B = new Array(A.length);

  for (let i = 0; i <= k; i++) {
    C[i] = 0;
  }
  for (let j = 0; j < A.length; j++) {
    //C[i]: número de elementos iguais a i
    C[A[j]] = C[A[j]] + 1;
  }
  for (let i = 1; i <= k; i++) {
    C[i] = C[i] + C[i - 1];
    //C[i]: número de elementos menores ou iguais a i
  }
  for (let j = A.length-1; j >= 0; j--) {
    B[C[A[j]] - 1] = A[j];
    C[A[j]] = C[A[j]] - 1;
  }
  return B;
}
const A = [93, 31, 51, 0, 0, 30, 65, 88, 37, 50, 6, 83, 60, 78, 31, 36, 77, 6, 56, 18, 12, 64, 69, 100, 81, 53, 13, 77, 9, 37, 100, 36, 42, 91, 30, 1, 20, 32, 25, 63, 17,67];

console.log(countingSort(A,100));
