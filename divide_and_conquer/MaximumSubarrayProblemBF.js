//Arrays compostos pela oscilação do preço da ação em N dias.
const A = [13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7]; // [ 7, 10, 43 ]

const B = [
  13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7, 10, -10, 5,
  -3, 4, -8, 11, -5, -9, 6, -1, 8, -13, 3, 9, -2, 12, -6, -7, 14, -4, 15, 0, 2,
  -3, 10, -15, 17, -8, -9, 6, 11, -12, 7,
]; //[ 7, 43, 74 ]

//Resolução utilizando Força Bruta. O(n^2)
function bruteForce_FindMaxSubarray(A) {
  let low, high;
  let max_soma = -Infinity;
  for (let i = 0; i < A.length; i++) {
    let soma = 0;
    for (let j = i; j < A.length; j++) {
      soma = soma + A[j];
      if (soma > max_soma) {
        max_soma = soma;
        low = i;
        high = j;
      }
    }
  }
  return [low, high, max_soma];
}

console.log(bruteForce_FindMaxSubarray(A));
