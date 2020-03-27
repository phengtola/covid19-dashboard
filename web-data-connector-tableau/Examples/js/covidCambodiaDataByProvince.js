(function() {
    // Create the connector object
    var myConnector = tableau.makeConnector();

    // Define the schema
    myConnector.getSchema = function(schemaCallback) {
        var cols = [
        {
            id: "province_en",
            alias: "province_en",
            dataType: tableau.dataTypeEnum.string
        }, 
        {
            id: "country",
            alias: "country",
            dataType: tableau.dataTypeEnum.string
        },
        {
            id: "province_kh",
            alias: "province_kh",
            dataType: tableau.dataTypeEnum.string
        },
        {
            id: "total_cases",
            alias: "total_cases",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "total_deaths",
            alias: "total_deaths",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "total_recovered",
            alias: "total_recovered",
            dataType: tableau.dataTypeEnum.float
        },{
            id: "updated_at",
            alias: "updated_at",
            dataType: tableau.dataTypeEnum.date
        }];

        var tableSchema = {
            id: "Covid-19 Cmabodia Data",
            alias: "Province",
            columns: cols
        };

        schemaCallback([tableSchema]);
    };

    // Download the data
    myConnector.getData = function(table, doneCallback) {
        $.getJSON("http://api.itadventure.org/itadventure/api/covid/cambodia/province", function(resp) {
            console.log(resp.data);
            var feat = resp.data,
            tableData = [];
            // Iterate over the JSON object
            for (var i = 0, len = feat.length; i < len; i++) {
                tableData.push({
                        "province_en": feat[i].province_en,
                        "country": feat[i].country,
                        "province_kh": feat[i].province_kh,
                        "total_cases": feat[i].total_cases,
                        "total_deaths": feat[i].total_deaths,
                        "total_recovered": feat[i].total_recovered,
                        "updated_date": feat[i].updated_date
                });
            }
                
            console.log("tableData", tableData);
            table.appendRows(tableData);
            doneCallback();
        });
    };

    tableau.registerConnector(myConnector);

    // Create event listeners for when the user submits the form
    $(document).ready(function() {
        $("#submitButton").click(function() {
            tableau.connectionName = "Covid-19 Cambodia Data | Province"; // This will be the data source name in Tableau
            tableau.submit(); // This sends the connector object to Tableau
        });
    });
})();
