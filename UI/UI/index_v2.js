
console.log("-index.js-");

// --------------------------
// using  DOM  + Timer API
// --------------------------


let clock3 = document.getElementById('clock3');
let clock4 = document.getElementById('clock4');


function Clock(porps) {
    let {timeZone}=porps;
    return (
        <div className="card">
            <div className="card-header bg-danger">{timeZone}</div>
            <div className="card-body">
                <span className="badge badge-dark">{new Date().toLocaleTimeString('en-US', { timeZone: 'Asia/Kolkata' })}</span>
            </div>
        </div>
    )
}

setInterval(() => {
   ReactDOM.render(<Clock timeZone="Asia/Kolkata"/>,clock3);
   ReactDOM.render(<Clock timeZone="Asia/Dubai"/>,clock4);
}, 1000);
