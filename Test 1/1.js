function duplicates(array) {
    const resultArry = [];
    for (var i = 0; i < array.length; i++) {
        for (var j = i + 1; j < array.length; j++) {
            if (array[i] == array[j]) {
                 resultArry.push(array[i]);
            }
        }
    }
return resultArry;
}
console.log(duplicates([1, 2, 3, 4,4]))