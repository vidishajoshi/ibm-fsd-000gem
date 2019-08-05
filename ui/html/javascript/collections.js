//map

let uMap = new Map();
uMap.set('one',"hello");
uMap.set('two',"hi");

for(let item of uMap.entries()){
    console.log(item);
}

//set

const uSet = new Set();
uSet.add("set 1");
uSet.add("set 2");
uSet.add("set 3");

for(let item of uSet){
    console.log(item);
}

//weakMap example

const mWeakMap = new WeakMap();
const obj1=new String('wOne');
const obj2=new String('wTwo');
const obj3=new String('wThree');

mWeakMap.set(obj1,'Weak Hello');
mWeakMap.set(obj2,'Weak Hi');
mWeakMap.set(obj3,'Weak Halo');

console.log(mWeakMap.get(obj1));

//weakset example

const mWeakSet=new WeakSet();
mWeakSet.add(obj1);
mWeakSet.add(obj2);
mWeakSet.add(obj3);

console.log('Weakset:', obj1);
console.log('Weakset:', obj2);
console.log('Weakset:', obj3);

//accumalateor
//reduce

const _nums = [9,3,2,4];                 //default left to write and trying on numbers
const _res = _nums.reduce((_p,_n)=>{
    return _p + _n;
});
console.log(_res);

const _nums1 = [9,3,2,4];                //changing the order to check wheter the answer remains same
const _res1 = _nums1.reduce((_p,_n)=>{
    return _n + _p;
});
console.log(_res1);

const halo=['Hi','Hey','Hello'];  //default left to right
const _try= halo.reduce((_p,_n)=>{
     return _p+_n;
});
console.log(_try);

const halo1=['Hi','Hey','Hello']; //convert right to left by changing the order
const _try1= halo1.reduce((_p,_n)=>{
     return _n+_p;
});
console.log(_try1);

const halo3=['Hi','Hey','Hello']; //convert right to left by using function reduceRight
const _try3= halo3.reduceRight((_p,_n)=>{
     return _p+_n;
});
console.log(_try3);

//try to find the salary sum

const emp =[
    {
        id:1,
        name: 'ram',
        salary:1000
    },
    {
        id:2,
        name: 'ram1',
        salary:1000
    },
    {
        id:3,
        name: 'ram2',
        salary:1000
    }
];

const _totalSalary = emp.reduce((_p,_n)=>{
    console.log(_p.salary);
   if(_p.salary!=undefined){
        console.log(_p.salary);
    } 
    return _p +=_n.salary;
    
},0);
console.log(`total salary : ${_totalSalary}`);

const emps = [
    {
        id : 1,
        name : 'Ram',
        email: 'ram@gg.com',
        organization: 'IBM',
        Designation:'Developer'
    },
    {
        id : 2,
        name : 'Shyam',
        email: 'shyam@gg.com',
        organization: 'IBM',
        Designation :'Tester'
    },
    {
        id : 3,
        name : 'Gabbar',
        email: 'gabbar@gg.com',
        organization: 'CTS',
        Designation: 'Developer'
    }
];

let groupByOrg = emps.reduceRight((acc,emp)=>{          //group emp by company
    let key=emp['organization'];
    if(!acc[key]){
        acc[key]=[];
    }
    acc[key].push(emp);
    return acc;
    },
   {});
   console.log(groupByOrg);


   
let groupByDesignatin = emps.reduceRight((acc,emp1)=>{     //group emp by designation
    let key=emp1['Designation'];   //emp1['Designation'] is equvialent to emp1.Designation
    if(!acc[key]){
        acc[key]=[];
    }
    acc[key].push(emp1);
    return acc;
    },
   {});
   console.log(groupByDesignatin);