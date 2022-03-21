var sum = 0;
var result = 0;
for (let i =1; i<=100;i++){
    if (i == 100){
        sum+=i;
        result =sum/100;
    }
    else{
        sum += i;
    }
}
console.log(result);