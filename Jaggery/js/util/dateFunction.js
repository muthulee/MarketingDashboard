var getLastDate  = function () {
    return Date.today().next().saturday();
};

var getYear = function(){
    return Date.today().next().saturday().getFullYear().toString();
};

var yyyymmdd = function(date) {

    var yyyy = date.getFullYear().toString();
    var mm = (date.getMonth()+1).toString(); // getMonth() is zero-based
    var dd  = date.getDate().toString();

    return yyyy + '-' + (mm[1]?mm:"0"+mm[0]) + '-' + (dd[1]?dd:"0"+dd[0]);
};

var getQNumforDate = function(date){
    return Math.floor((date.getMonth() + 3) / 3);
};

var weekRangeContainsEOQ = function(startDate,endDate,year){

    //Months are zero based
    var quarterEndDates = [ { "month" : "02", "date" : "31"} , { "month" : "05", "date" : "30"}, { "month" : "08",
        "date" : "30"}, { "month" : "11", "date" : "31"}];

    var quarterDate;

    for(var i =0 ; i< quarterEndDates.length; i++){
        quarterDate = new Date();
        quarterDate.setFullYear(year, quarterEndDates[i].month, quarterEndDates[i].date);
        if( (quarterDate > startDate) && (quarterDate < endDate) ){
            return 1;
        }
    }
    return -1;
};
