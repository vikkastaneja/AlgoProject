(function(win){
    var ncon = win.console;

    var con = win.console = {
        backlog: []
    };

    for(var k in ncon) {
        if(typeof ncon[k] === 'function') {
            con[k] = (function(fn) {
                return function() {
                    con.backlog.push([new Date(), fn, arguments]);
                    ncon[fn].apply(ncon, arguments);
                };
            })(fn);
        }
    }
})(window);
