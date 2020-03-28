(function() {
    // Create the connector object
    var myConnector = tableau.makeConnector();

    // Define the schema
    myConnector.getSchema = function(schemaCallback) {
        var cols = [
            {
            id: "id",
            dataType: tableau.dataTypeEnum.int
            },
            {
                id: "total_cases",
                dataType: tableau.dataTypeEnum.int
            }, {
                id: "new_cases",
                dataType: tableau.dataTypeEnum.int
            }, {
                id: "total_deaths",
                dataType: tableau.dataTypeEnum.int
            }, {
                id: "new_deaths",
                dataType: tableau.dataTypeEnum.int
            }, {
                id: "total_recovered",
                dataType: tableau.dataTypeEnum.int
            }, {
                id: "active_cases",
                dataType: tableau.dataTypeEnum.int
            }, {
                id: "serious_critical",
                dataType: tableau.dataTypeEnum.int
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
            dataType: tableau.dataTypeEnum.datetime
        }];

        var tableSchema = {
            id: "covidWorldData",
            alias: "TOTAL COVID",
            columns: cols
        };

        schemaCallback([tableSchema]);
    };

    // Download the data
    myConnector.getData = function(table, doneCallback) {
        $.getJSON("http://api.itadventure.org/itadventure/api/covid/world", function(resp) {
        //$.getJSON("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_week.geojson", function(resp) {
            var feat = resp.data,
                tableData = [];

            // Iterate over the JSON object
                tableData.push({
                    "id": feat.id,
                    "total_cases": feat.total_cases,
                    "new_cases": feat.new_cases,
                    "total_deaths": feat.total_deaths,
                    "new_deaths": feat.new_deaths,
                    "total_recovered": feat.total_recovered,
                    "active_cases": feat.active_cases,
                    "serious_critical": feat.serious_critical,
                    "tot_cases1m_pop": feat.tot_cases1m_pop,
                    "tot_deaths1m_pop": feat.tot_deaths1m_pop,
                    "updated_at": feat.updated_at
                });

            table.appendRows(tableData);
            doneCallback();
        });
    };

    tableau.registerConnector(myConnector);

    // Create event listeners for when the user submits the form
    $(document).ready(function() {
        $("#submitButton").click(function() {
            tableau.connectionName = "TOTAL COVID"; // This will be the data source name in Tableau
            tableau.submit(); // This sends the connector object to Tableau
        });
    });
})();
