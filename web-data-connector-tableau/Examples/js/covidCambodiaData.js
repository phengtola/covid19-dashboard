(function() {
    // Create the connector object
    var myConnector = tableau.makeConnector();

    // Define the schema
    myConnector.getSchema = function(schemaCallback) {
        var cols = [{
            id: "id",
            alias: "id",
            dataType: tableau.dataTypeEnum.float
        }, {
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
        }, {
            id: "total_male",
            alias: "total_male",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "total_female",
            alias: "total_female",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "total_usa",
            alias: "total_usa",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "total_belgium",
            alias: "total_belgium",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "total_china",
            alias: "total_china",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "total_england",
            alias: "total_england",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "total_malaysia",
            alias: "total_malaysia",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "total_cambodia",
            alias: "total_cambodia",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "updated_at",
            alias: "updated_at",
            dataType: tableau.dataTypeEnum.date
        }];

        var tableSchema = {
            id: "Covid-19 Cmabodia Data",
            alias: "Total",
            columns: cols
        };

        schemaCallback([tableSchema]);
    };

    // Download the data
    myConnector.getData = function(table, doneCallback) {
        $.getJSON("http://api.itadventure.org/itadventure/api/covid/cambodia", function(resp) {
            console.log(resp.data);
            var feat = resp.data,
            tableData = [];
            // Iterate over the JSON object
                tableData.push({
                        "id": feat.id,
                        "total_cases": feat.total_cases,
                        "total_deaths": feat.total_deaths,
                        "total_recovered": feat.total_recovered,
                        "total_male": feat.total_male,
                        "total_female": feat.total_female,
                        "total_usa": feat.total_usa,
                        "total_belgium": feat.total_belgium,
                        "total_china": feat.total_china,
                        "total_england": feat.total_england,
                        "total_malaysia": feat.total_malaysia,
                        "total_cambodia": feat.total_cambodia,
                        "updated_date": feat.updated_date
                });
            console.log("tableData", tableData);
            table.appendRows(tableData);
            doneCallback();
        });
    };

    tableau.registerConnector(myConnector);

    // Create event listeners for when the user submits the form
    $(document).ready(function() {
        $("#submitButton").click(function() {
            tableau.connectionName = "Covid-19 World Data"; // This will be the data source name in Tableau
            tableau.submit(); // This sends the connector object to Tableau
        });
    });
})();
