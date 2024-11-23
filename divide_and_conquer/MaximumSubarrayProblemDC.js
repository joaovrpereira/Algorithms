//Arrays compostos pela oscilação do preço da ação em N dias.
const A = [13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7]; // [ 7, 10, 43 ]

const B = [
  13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7, 10, -10, 5,
  -3, 4, -8, 11, -5, -9, 6, -1, 8, -13, 3, 9, -2, 12, -6, -7, 14, -4, 15, 0, 2,
  -3, 10, -15, 17, -8, -9, 6, 11, -12, 7,
]; //[ 7, 43, 74 ]

function find_max_crossing_subarray(A, low, mid, high) {
  let left_sum = -Infinity;
  let sum = 0;
  let max_left;

  for (let i = mid; i >= low; i--) {
    sum = sum + A[i];
    if (sum > left_sum) {
      left_sum = sum;
      max_left = i;
    }
  }
  let right_sum = -Infinity;
  sum = 0;
  let max_right;

  for (let j = mid + 1; j <= high; j++) {
    sum = sum + A[j];
    if (sum > right_sum) {
      right_sum = sum;
      max_right = j;
    }
  }
  return [max_left, max_right, left_sum + right_sum];
}

function find_max_subarray(A, low, high) {
  let left_low, left_high, left_sum;
  let right_low, right_high, right_sum;
  let cross_low, cross_high, cross_sum;

  if (high === low) {
    return [low, high, A[low]]; //um elemento
  } else {
    const mid = Math.floor((low + high) / 2);
    //Divisão em três subproblemas:

    //Solução está na primeira metade de A[1..mid]
    const [left_low, left_high, left_sum] = find_max_subarray(A, low, mid);
    //Solução está na segunda metade de A[mid+1..high]
    const [right_low, right_high, right_sum] = find_max_subarray(
      A,
      mid + 1,
      high
    );
    //Solução contida em A[i..j], tal que low<i<mid e mid<j<high
    const [cross_low, cross_high, cross_sum] = find_max_crossing_subarray(
      A,
      low,
      mid,
      high
    );
    //O subarray maior contido nos três subproblemas é retornado
    if (left_sum >= right_sum && left_sum >= cross_sum) {
      return [left_low, left_high, left_sum];
    } else if (right_sum >= left_sum && right_sum >= cross_sum) {
      return [right_low, right_high, right_sum];
    } else return [cross_low, cross_high, cross_sum];
  }
}
console.log(find_max_subarray(A, 0, A.length - 1));
