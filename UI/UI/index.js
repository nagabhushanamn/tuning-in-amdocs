
console.log("-index.js-");

// --------------------------
// using  DOM  + Timer API
// --------------------------


let clock1 = document.getElementById('clock1');
let clock2 = document.getElementById('clock2');


setInterval(() => {
    clock1.innerHTML = `
    <div class="card">
        <div class="card-header bg-danger">Asia/Kolkata</div>
        <div class="card-body">
        <span class="badge badge-dark">${new Date().toLocaleTimeString('en-US', { timeZone: 'Asia/Kolkata' })}</span>
        </div>
    </div>
    `
}, 1000);

setInterval(() => {
    clock2.innerHTML = `
    <div class="card">
        <div class="card-header bg-danger">Asia/Kolkata</div>
        <div class="card-body">
        <span class="badge badge-dark">${new Date().toLocaleTimeString('en-US', { timeZone: 'Asia/Dubai' })}</span>
        </div>
    </div>
    `
}, 1000);