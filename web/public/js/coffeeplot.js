$(function () {
    var coffee_data = [];
    // configuration
    var data_size = 60;
    var refresh_rate = 2000; // refresh rate in milliseconds.

    $("#data_size_input").val(data_size).change(function () {
        var v = $(this).val();
        if (v && !isNaN(+v)) {
            data_size = +v;
            if (data_size < 1)
                data_size = 1;
            if (data_size > 5000)
                data_size = 5000;
            $(this).val("" + data_size);
        } 
    });

    $("#refresh_rate_input").val(refresh_rate).change(function () {
        var v = $(this).val();
        if (v && !isNaN(+v)) {
            refresh_rate = +v;
            if (refresh_rate < 1)
                refresh_rate = 1;
            if (refresh_rate > 5000)
                refresh_rate = 5000;
            $(this).val("" + refresh_rate);
        } 
    });

    // setup plot
    var options = {
        series: { shadowSize: 3 }, // drawing is faster without shadows
        xaxis: { show: false }
    };

    function getData() {
        var most_recent = 0;
        var start_time = 0;
        var end_time = 0;
        if (coffee_data.length > 0) most_recent = coffee_data[0][0];

        function callback(json_data) {
            json = eval(json_data); // parse JSON array

            $.each(json, function(i, item) {
                coffee_data.push([item.time, item.weight]);
            });

            coffee_data.sort();
            coffee_data.reverse();
            if (coffee_data.length > data_size) coffee_data = coffee_data.slice(0,data_size);
            series = [{ 
                data: coffee_data,
                lines: { fill: true }
            }];
            $.plot($("#placeholder"), series, options);
        };

        var apiCall = '/last/' + data_size; 
        if (coffee_data.length >= data_size) apiCall = '/since/' + most_recent;

        $.ajax({
          type: "GET",
          url: 'api' + apiCall,
          dataType: "json",
          contentType: "text/plain; charset=utf-8",
          success: callback,
        });

        setTimeout(getData, refresh_rate);
    }

    getData();

});
