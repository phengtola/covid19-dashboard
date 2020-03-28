(function() {
    // Create the connector object
    var myConnector = tableau.makeConnector();

    // Define the schema
    myConnector.getSchema = function(schemaCallback) {
        var cols = [
            {
            id: "id",
            alias: "id",
            dataType: tableau.dataTypeEnum.int
        },
            // total_cases
            {
            id: "total_cases",
            alias: "total_cases",
            dataType: tableau.dataTypeEnum.int
        }, {
            id: "total_cases_male",
            alias: "total_cases_male",
            dataType: tableau.dataTypeEnum.int
        }, {
            id: "total_cases_female",
            alias: "total_cases_female",
            dataType: tableau.dataTypeEnum.int
        }, {
            id: "total_cases_belgium",
            alias: "total_cases_belgium",
            dataType: tableau.dataTypeEnum.int
        }, {
            id: "total_cases_cambodia",
            alias: "total_cases_cambodia",
            dataType: tableau.dataTypeEnum.int
        }, {
            id: "total_cases_canada",
            alias: "total_cases_canada",
            dataType: tableau.dataTypeEnum.int
        }, {
            id: "total_cases_china",
            alias: "total_cases_china",
            dataType: tableau.dataTypeEnum.int
        }, {
            id: "total_cases_england",
            alias: "total_cases_england",
            dataType: tableau.dataTypeEnum.int
        }, {
            id: "total_cases_france",
            alias: "total_cases_france",
            dataType: tableau.dataTypeEnum.int
        }, {
            id: "total_cases_indonesia",
            alias: "total_cases_indonesia",
            dataType: tableau.dataTypeEnum.int
        }, {
            id: "total_cases_malaysia",
            alias: "total_cases_malaysia",
            dataType: tableau.dataTypeEnum.int
        }
        , {
            id: "total_cases_usa",
            alias: "total_cases_usa",
            dataType: tableau.dataTypeEnum.int
        },

            // active_cases
            {
                id: "total_active_cases",
                alias: "total_active_cases",
                dataType: tableau.dataTypeEnum.int
            }
            , {
                id: "total_active_cases_female",
                alias: "total_active_cases_female",
                dataType: tableau.dataTypeEnum.int
            }
            , {
                id: "total_active_cases_male",
                alias: "total_active_cases_male",
                dataType: tableau.dataTypeEnum.int
            },

            // recovered
            {
                id: "total_recovered",
                alias: "total_recovered",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_recovered_male",
                alias: "total_recovered_male",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_recovered_female",
                alias: "total_recovered_female",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_recovered_belgium",
                alias: "total_recovered_belgium",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_recovered_cambodia",
                alias: "total_recovered_cambodia",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_recovered_canada",
                alias: "total_recovered_canada",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_recovered_china",
                alias: "total_recovered_china",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_recovered_england",
                alias: "total_recovered_england",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_recovered_france",
                alias: "total_recovered_france",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_recovered_indonesia",
                alias: "total_recovered_indonesia",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_recovered_malaysia",
                alias: "total_recovered_malaysia",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_recovered_usa",
                alias: "total_recovered_usa",
                dataType: tableau.dataTypeEnum.int
            }

            // Deaths
            ,{
                id: "total_deaths",
                alias: "total_deaths",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_deaths_female",
                alias: "total_deaths_female",
                dataType: tableau.dataTypeEnum.int
            }
            ,{
                id: "total_deaths_male",
                alias: "total_deaths_male",
                dataType: tableau.dataTypeEnum.int
            }
        , {
            id: "updated_date",
            alias: "updated_date",
            dataType: tableau.dataTypeEnum.datetime
        }];

        var tableSchema = {
            id: "covidCambodiaData",
            alias: "TOTAL COVID IN CAMBODIA",
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
                    "total_cases_male": feat.total_cases_male,
                    "total_cases_female": feat.total_cases_female,
                    "total_cases_belgium": feat.total_cases_belgium,
                    "total_cases_cambodia": feat.total_cases_cambodia,
                    "total_cases_canada": feat.total_cases_canada,
                    "total_cases_china": feat.total_cases_china,
                    "total_cases_england": feat.total_cases_england,
                    "total_cases_france": feat.total_cases_france,
                    "total_cases_indonesia": feat.total_cases_indonesia,
                    "total_cases_malaysia": feat.total_cases_malaysia,
                    "total_cases_usa": feat.total_cases_usa,

                    "total_active_cases": feat.total_active_cases,
                    "total_active_cases_female": feat.total_active_cases_female,
                    "total_active_cases_male": feat.total_active_cases_male,

                    "total_recovered": feat.total_recovered,
                    "total_recovered_male": feat.total_recovered_male,
                    "total_recovered_female": feat.total_recovered_female,
                    "total_recovered_belgium": feat.total_recovered_belgium,
                    "total_recovered_cambodia": feat.total_recovered_cambodia,
                    "total_recovered_canada": feat.total_recovered_canada,
                    "total_recovered_china": feat.total_recovered_china,
                    "total_recovered_england": feat.total_recovered_england,
                    "total_recovered_france": feat.total_recovered_france,
                    "total_recovered_indonesia": feat.total_recovered_indonesia,
                    "total_recovered_malaysia": feat.total_recovered_malaysia,
                    "total_recovered_usa": feat.total_recovered_usa,

                    "total_deaths": feat.total_deaths,
                    "total_deaths_female": feat.total_deaths_female,
                    "total_deaths_male": feat.total_deaths_male,

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
            tableau.connectionName = "TOTAL COVID IN CAMBODIA"; // This will be the data source name in Tableau
            tableau.submit(); // This sends the connector object to Tableau
        });
    });
})();
