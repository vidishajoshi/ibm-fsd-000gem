'use strict';
console.log("hello");
document.write('Welcome');

var uId= 10;/*defining a variabel */
console.log('uId is ',uId);
uId = 'BOd';
console.log('uId is modified ',uId);
console.log(`uId is modoidfied ${uId}  `) /*this dollar sign is defined to expalain that it is varible among the fgiven string which is given in inverted comma*/

document.write(`sum is ~ ${3+4}`);

let a = 11
let b = 12

//add
document.write(`sum i  ~ ${a+b}`);
document.write('<br/>');
//diff
//mul

let vals=[1,4,'hello'];
//print array
console.log(vals);

//print specific value
console.log(vals[2 ]);

//modify an element 
vals[1]=88;

//reprint an array
console.log(vals[1]);

//remove an element
delete vals[0];

//another way of writing an array
//for more complex array
//doing varibal e decoration
let user1 ={
    id:1, name:'user one',
    phone: 123,
    email:'use1@email.com'
};

let user2 ={
    id:2, name:'user two',
    phone: 456
,
email:'use2@email.com'
};
let users = [
user1,user2
];

console.log(users[0].id);

//other example whihc porray teh email

//USE of conditional statement

//if statment
if(users[1].email==undefined){
console.log('Oops email doesnt exist');
}

//if we wont specifiy the problem then it alwayas print undefined

//if else
if(users[1].email==undefined){
    console.log('Oops email doesnt exist');
}else if(users[1].email == 'us2@gg.com'){
    console.log('within the else if');
    console.log(users[1].email);
}
else{
    console.log('within the else');
console.log(users[1].email);
}    

//arithimatic example

/*let i = 11;
let j = 12;
if (i >= j)
{
    console.log(`${i} is greater than ${j}`);

}else
{
    console.log(`${j} is greater than ${i}`);
}*/

//example

let e=58;
let m=67;
let c=89;

if(e >= 60){
    if(m >= 60)
    {
        if( c >= 60)
        {
            var sum = e+m+c;
            var per= (sum/300)*100
            console.log(`total percentage is ${per} and you are pass`);
    }
    }
} else{
        console.log('you are fail');
    }

var evenNums = [2,4,6,8];
evenNums.push(10);

console.log('event numbers '+evenNums);

evenNums.pop();
console.log('event number er'+evenNums);

var oddNums = [1,3,5,7];
oddNums = oddNums.concat(evenNums);
console.log(oddNums);

//for loop
let io=0;
for(io=0;io<5;io++)
{
    console.log(io);
}

//while loop
 let j1=0;
while( j1<5){
    console.log(j1);
    j1++;
}

//do while
let ij=10;
do{
    console.log(ij);
    ij++;
}while(ij<15);

//break stament
console.log('break statment');
let _index = 0;
for(_index=0;_index<5;_index++){
    console.log(_index);
    if(_index == 2){
        break;
    }
}

//continue statment
console.log('continue statement');
let _index_ = 0;
for(_index_=0;_index_<5;_index_++){
    console.log(_index_);
    if(_index_ == 2){
        continue;
    }
}


//fibonacci series
console.log('fibonacci')
let num=3;
let a2=0;
let b2=1;
let c2=a2+b2;
let it=1;
console.log(a2);
console.log(b2);

while(it<4)
{

    console.log(c2);
    c2=it+c2;
    it++;    
}

let messages=['Hello','Hi','Hola']; //indexes

for (let m of messages){
    console.log(m);
}
vals={
    one:'One',
    two:'two'
};
console.log(Object.keys(vals));

//FUNCTIONs

/*
function clickMe(){
    const name = document.getElementById('name');
    alert(`Hello ${name.value}`);
   name.value='IBM';
   let rows;
  for(let m1 of messages){
     rows +=`<tr.<th>${m1+1}</th><th>${messages[m1]}</th></tr>`;
   }
let _table=`<table>
            <tr><th>S.no</th><th>Messages</th></tr>
            <tr><th>1</th><th>Hello</th></tr>
            <tr><th>2</th><th>Hola</th></tr>
            </table>`;
        document.getElementById('msgs').innerHTML=_table;

}
*/

function res(){
    let eng=document.getElementById('e_id');
    let math=document.getElementById('m_id');
    let comp=document.getElementById('c_id');
    
    let result = 0;
    if(eng >= 60 && math >= 60 && comp >= 60)
    {
        result='Pass';
    }else{
        result='Fail';
    }

    let _tab = `<table>
    <tr><th>Sub</th><th>Marks</th></tr>
    <tr><th>English</th><th>${eng.value}</th></tr>
    <tr><th>Maths</th><th>${math.value}</th></tr>
    <tr><th>Computer</th><th>${comp.value}</th></tr>
    <tr><th>Result</th><th>${result}</th></tr>
    </table>`;

    document.getElementById('tab').innerHTML=_tab;

}








































































