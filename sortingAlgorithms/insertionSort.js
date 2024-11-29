//Tempo O(n²)
function insertionSort(A){
    for(let i =1; i<A.length; i++){
        let key = A[i];
        let j = i -1;
        while(j >= 0 && A[j] > key){
            A[j+1] = A[j];
            j--;
        }
        A[j+1] = key;
    }
    return A;
}
const A = [93, 31, 51, 0, 0, 30, 65, 88, 37, 50, 6, 83, 60, 78, 31, 36, 77, 6, 56, 18, 12, 64, 69, 100, 81, 53, 13, 77, 9, 37, 100, 36, 42, 91, 30, 1, 20, 32, 25, 63, 17,67];
console.log(insertionSort(A))

