(function() {
    // Create the connector object
    var myConnector = tableau.makeConnector();

    // Define the schema
    myConnector.getSchema = function(schemaCallback) {
        var cols = [{
            id: "country",
            alias: "country",
            dataType: tableau.dataTypeEnum.string
        }, {
            id: "total_cases",
            alias: "total_cases",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "new_cases",
            alias: "new_cases",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "total_deaths",
            alias: "total_deaths",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "new_deaths",
            alias: "new_deaths",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "total_recovered",
            alias: "total_recovered",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "active_cases",
            alias: "active_cases",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "serious_critical",
            alias: "serious_critical",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "tot_cases1m_pop",
            alias: "tot_cases1m_pop",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "tot_deaths1m_pop",
            alias: "tot_deaths1m_pop",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "updated_at",
            alias: "updated_at",
            dataType: tableau.dataTypeEnum.date
        }];

        var tableSchema = {
            id: "Covid-19 World Data",
            alias: "Country",
            columns: cols
        };

        schemaCallback([tableSchema]);
    };

    // Download the data
    myConnector.getData = function(table, doneCallback) {
        $.getJSON("http://api.itadventure.org/itadventure/api/covid/world/country", function(resp) {
            console.log(resp.data);
            var feat = resp.data,
            tableData = [];
            // Iterate over the JSON object
             for (var i = 0, len = feat.length; i < len; i++) {
                tableData.push({
                    "country": feat[i].country,
                    "total_cases": feat[i].total_cases,
                    "new_cases": feat[i].new_cases,
                    "total_deaths": feat[i].total_deaths,
                    "new_deaths": feat[i].new_deaths,
                    "total_recovered": feat[i].total_recovered,
                    "active_cases": feat[i].active_cases,
                    "serious_critical": feat[i].serious_critical,
                    "tot_cases1m_pop": feat[i].tot_cases1m_pop,
                    "tot_deaths1m_pop": feat[i].tot_deaths1m_pop,
                    "updated_at": feat[i].updated_at
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
            tableau.connectionName = "Covid-19 World Data | Country"; // This will be the data source name in Tableau
            tableau.submit(); // This sends the connector object to Tableau
        });
    });
})();
