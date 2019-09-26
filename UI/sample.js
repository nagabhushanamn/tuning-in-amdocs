




/*

<button class="veg">Veg</button>
<button class="non-veg">Non-Veg</button>

*/

$.on('.veg','click',function vegHandler(e){
    console.log("handling veg event");  
})

$.on('.non-veg','click',function nonVegHandler(e){
    console.log("handling non-veg event");  
})
console.log("cont with other wok..");  


setTimeout(function(){
    console.log("do something...");  
},3000);

console.log("cont....")