// console.log("hello".length);

// console.log("hello".charAt(0));

// console.log("hello, world".replace("hello","goodbye"));

// console.log("hello, world".toUpperCase());

// var myName = "Alex";

// console.log(myName);

// let a = 1;

// console.log(a);

// const PI =3.14;
// console.log(PI);

// var myName ="Daniel";
// var age =20;

// if (index == "simon" ){
//     console.log("simon");
// }else if(index=="john"){
//     console.log("john");
// }else{
//     console.log("Stranger");
// }

// while(0){
//     console.log("true");
// }

// // if(true){
// //     let age =20;
// // }

// var a=19;

// do{
//     a++;
//     console.log(a);
// }while(age==a);

// for(let i=0; i<5; i++){
//     age++;
//     console.log(age);
// }

// var allowed =(age>=18)?"Yes":"NO";
// console.log(allowed);

// switch(myName){
//     case 'simon':
//         console.log("simon");
//         break;
//     case 'john':
//         console.log("john");
//         BroadcastChannel;
//     default:
//         console.log("stranger");
// }



// var obj =new Object;
// var obj2 = {};

// obj= {
//     objName:"Simon",
//     age:'20',
//     email:"simon@gmail.com",
//     contact:{
//         phone:"1234567",
//         Telegram:"@Simon"
//     }
// };

// obj.age='21';
// obj.contact.WeChat="abcd";

// console.log(obj.age);
// console.log(obj.contact.phone);
// console.log(obj["contact"]["phone"]);
// console.log(obj.contact);

// var a = new Array();
// var b =[];

// a[0] = "dog";
// a[1] = "cat";
// a[5] = "tiger";

// console.log(a);

// b=["dog","cat","tiger"];

// b.push("sheep");//最后添加一项
// b.pop();//删除最后一项
// b.shift();//删除第一项
// b.reverse()//倒转数组
// b.unshift("lion");//在第一项添加

// console.log(b);

// for(let i =0; i<b.length;i++){
//     console.log(b[i]);
// }

// for(let i in a){
//     console.log(a[i]);
// }

// let a=1;

// function add(x) {
//     a+=x;
// }

// add(4);

// console.log(a);


// function add(){
//     let sum = 0;
//     for (let i = 0, j = arguments.length; i < j; i++){
//         sum +=arguments[i];
//     }

//     return sum;
// }

// let sum = add(1,2,3,4,5,6,7,8,9,10);

// console.log(sum);


//回调函数 闭包
function makeAdder(a){
    return function(b){
        b /=  2;
        return a + b;
    };
}

var x = makeAdder(5);
var sum = x(6);

console.log(sum);