Feature: Rock Center Production Request Creation Service validations 

  Background: 
    #Given user gets ncxjwttoken
    Given user set up base uri

  @ROCKCENTER_CREATION_SERVICE @mar17
  Scenario Outline: To Create Studio Production Requests "<scenario_name>"
    When user set up headers
      | Content-Type | application/Json |
      | messageid    | sdsddsd12        |
      | userId       | en               |
    And user read data "<scenario_name>" and create payload for "Create_Studio_Prod_Req"
    Then user invokes "Create_Studio_Prod_Req" service to create new request
      """

      """
    Then validate the status code "<status_code>"
    Then fetch request id "studioRequestID"
    Then validate the "Create_Studio_Prod_Req" response values

    Examples: 
      | scenario_name                                                                                                                             | status_code |
      #=========================To Verify Rock Center Request creation with all fields ============================================
      | Creating request with all fields                                                                                                          |         201 |
      #=========================To Verify Rock Center Request creation with only mandatory fields =================================
      | Creating request with only mandatory fields                                                                                               |         201 |
      #========================To Verify Rock Center Requests creations combinations of All RequestFor and Divisions ==============
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Rehearsal]                                               |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Rehearsal]                                                  |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Rehearsal]                                                   |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Rehearsal]                                                 |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Rehearsal]                                            |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Rehearsal]                                          |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Rehearsal]                                        |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Rehearsal]                                           |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Rehearsal]                                           |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Rehearsal]                                     |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Rehearsal]                                           |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Rehearsal]                                         |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Rehearsal]                                             |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Rehearsal]                                           |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Rehearsal]                                              |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Rehearsal]                                            |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Rehearsal]                                       |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Set Lighting]                                            |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Set Lighting]                                               |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Set Lighting]                                                |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Set Lighting]                                              |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Set Lighting]                                         |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Set Lighting]                                       |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Set Lighting]                                     |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Set Lighting]                                        |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Set Lighting]                                        |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Set Lighting]                                  |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Set Lighting]                                        |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Set Lighting]                                      |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Set Lighting]                                          |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Set Lighting]                                        |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Set Lighting]                                           |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Set Lighting]                                         |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Set Lighting]                                    |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Scenic Setup or Strike]                                  |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Scenic Setup or Strike]                                     |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Scenic Setup or Strike]                                      |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                                    |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                               |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                             |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                           |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                              |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                              |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                        |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                              |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                            |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                                |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                              |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                                 |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                               |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Scenic Setup or Strike]                          |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Show Build/Config]                                       |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Show Build/Config]                                          |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Show Build/Config]                                           |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Show Build/Config]                                         |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Show Build/Config]                                    |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Show Build/Config]                                  |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Show Build/Config]                                |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Show Build/Config]                                   |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Show Build/Config]                                   |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Show Build/Config]                             |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Show Build/Config]                                   |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Show Build/Config]                                 |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Show Build/Config]                                     |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Show Build/Config]                                   |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Show Build/Config]                                      |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Show Build/Config]                                    |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Show Build/Config]                               |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Other]                                                   |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Other]                                                      |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Other]                                                       |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Other]                                                     |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Other]                                                |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Other]                                              |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Other]                                            |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Other]                                               |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Other]                                               |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Other]                                         |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Other]                                               |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Other]                                             |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Other]                                                 |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Other]                                               |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Other]                                                  |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Other]                                                |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Other]                                           |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Crew for External Remote]                                |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Crew for External Remote]                                   |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Crew for External Remote]                                    |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Crew for External Remote]                                  |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Crew for External Remote]                             |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Crew for External Remote]                           |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Crew for External Remote]                         |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Crew for External Remote]                            |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Crew for External Remote]                            |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Crew for External Remote]                      |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Crew for External Remote]                            |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Crew for External Remote]                          |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Crew for External Remote]                              |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Crew for External Remote]                            |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Crew for External Remote]                               |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Crew for External Remote]                             |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Crew for External Remote]                        |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Crew for Meeting]                                        |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Crew for Meeting]                                           |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Crew for Meeting]                                            |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Crew for Meeting]                                          |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Crew for Meeting]                                     |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Crew for Meeting]                                   |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Crew for Meeting]                                 |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Crew for Meeting]                                    |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Crew for Meeting]                                    |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Crew for Meeting]                              |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Crew for Meeting]                                    |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Crew for Meeting]                                  |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Crew for Meeting]                                      |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Crew for Meeting]                                    |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Crew for Meeting]                                       |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Crew for Meeting]                                     |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Crew for Meeting]                                |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Crew for Training]                                       |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Crew for Training]                                          |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Crew for Training]                                           |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Crew for Training]                                         |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Crew for Training]                                    |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Crew for Training]                                  |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Crew for Training]                                |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Crew for Training]                                   |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Crew for Training]                                   |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Crew for Training]                             |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Crew for Training]                                   |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Crew for Training]                                 |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Crew for Training]                                     |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Crew for Training]                                   |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Crew for Training]                                      |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Crew for Training]                                    |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Crew for Training]                               |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Camera Blocking]                                         |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Camera Blocking]                                            |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Camera Blocking]                                             |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Camera Blocking]                                           |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Camera Blocking]                                      |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Camera Blocking]                                    |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Camera Blocking]                                  |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Camera Blocking]                                     |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Camera Blocking]                                     |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Camera Blocking]                               |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Camera Blocking]                                     |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Camera Blocking]                                   |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Camera Blocking]                                       |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Camera Blocking]                                     |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Camera Blocking]                                        |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Camera Blocking]                                      |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Camera Blocking]                                 |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]           |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]              |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]               |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]             |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]        |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]      |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]    |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]       |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]       |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair] |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]       |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]     |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]         |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]       |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]          |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]        |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Equipment Replacement / Installation / Repair]   |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                                   |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                                      |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                                       |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                                     |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                                |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                              |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                            |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                               |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                               |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                         |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                               |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                             |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                                 |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                               |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                                  |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                                |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Fax Check/ESU/Testing]                           |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Bridge Crew]                                             |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Bridge Crew]                                                |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Bridge Crew]                                                 |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Bridge Crew]                                               |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Bridge Crew]                                          |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Bridge Crew]                                        |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Bridge Crew]                                      |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Bridge Crew]                                         |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Bridge Crew]                                         |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Bridge Crew]                                   |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Bridge Crew]                                         |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Bridge Crew]                                       |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Bridge Crew]                                           |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Bridge Crew]                                         |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Bridge Crew]                                            |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Bridge Crew]                                          |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Bridge Crew]                                     |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Extend Crew]                                             |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Extend Crew]                                                |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Extend Crew]                                                 |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Extend Crew]                                               |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Extend Crew]                                          |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Extend Crew]                                        |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Extend Crew]                                      |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Extend Crew]                                         |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Extend Crew]                                         |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Extend Crew]                                   |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Extend Crew]                                         |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Extend Crew]                                       |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Extend Crew]                                           |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Extend Crew]                                         |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Extend Crew]                                            |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Extend Crew]                                          |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Extend Crew]                                     |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Additional Crew for Existing Production]                 |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Additional Crew for Existing Production]                    |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Additional Crew for Existing Production]                     |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]                   |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]              |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]            |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]          |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]             |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]             |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]       |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]             |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]           |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]               |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]             |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]                |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]              |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Additional Crew for Existing Production]         |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                              |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                                 |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                                  |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                                |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                           |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                         |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                       |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                          |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                          |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                    |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                          |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                        |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                            |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                          |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                             |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                           |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Photo Shoot at Rock Center]                      |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                      |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                         |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                          |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                        |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                   |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                 |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]               |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                  |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                  |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]            |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                  |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                    |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                  |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                     |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]                   |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Video/Digital Shoot at Rock Center]              |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                          |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                             |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                              |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                            |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                       |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                     |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                   |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                      |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                      |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                      |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                    |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                        |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                      |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                         |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                       |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Pretape / Post-tape Segment(s)]                  |         201 |
      | Creating request with Division - NBC News and location - ROCK Centre and RequestFor - Internal Event                                      |         201 |
      | Creating request with Division - MSNBC and location - ROCK Centre and RequestFor - Internal Event                                         |         201 |
      | Creating request with Division - CNBC and location - ROCK Centre and RequestFor - Internal Event                                          |         201 |
      | Creating request with Division - Acorn and location - ROCK Centre and RequestFor - Internal Event                                         |         201 |
      | Creating request with Division - Corporate and location - ROCK Centre and RequestFor - Internal Event                                     |         201 |
      | Creating request with Division - Engineering and location - ROCK Centre and RequestFor - Internal Event                                   |         201 |
      | Creating request with Division - Entertainment and location - ROCK Centre and RequestFor - Internal Event                                 |         201 |
      | Creating request with Division - ERG Events and location - ROCK Centre and RequestFor - Internal Event                                    |         201 |
      | Creating request with Division - Facilities and location - ROCK Centre and RequestFor - Internal Event                                    |         201 |
      | Creating request with Division - NBC News Studios and location - ROCK Centre and RequestFor - Internal Event                              |         201 |
      | Creating request with Division - NBC Sports and location - ROCK Centre and RequestFor - Internal Event                                    |         201 |
      | Creating request with Division - News Digital and location - ROCK Centre and RequestFor - Internal Event                                  |         201 |
      | Creating request with Division - Olympics and location - ROCK Centre and RequestFor - Internal Event                                      |         201 |
      | Creating request with Division - Operations and location - ROCK Centre and RequestFor - Internal Event                                    |         201 |
      | Creating request with Division - Peacock and location - ROCK Centre and RequestFor - Internal Event                                       |         201 |
      | Creating request with Division - Telemundo and location - ROCK Centre and RequestFor - Internal Event                                     |         201 |
      | Creating request with Division - Universal Kids and location - ROCK Centre and RequestFor - Internal Event                                |         201 |
      | Creating request with Division - NBC News and location - ROCK Centre and RequestFor - Additional Live Show                                |         201 |
      | Creating request with Division - MSNBC and location - ROCK Centre and RequestFor - Additional Live Show                                   |         201 |
      | Creating request with Division - CNBC and location - ROCK Centre and RequestFor - Additional Live Show                                    |         201 |
      | Creating request with Division - Acorn and location - ROCK Centre and RequestFor - Additional Live Show                                   |         201 |
      | Creating request with Division - Corporate and location - ROCK Centre and RequestFor - Additional Live Show                               |         201 |
      | Creating request with Division - Engineering and location - ROCK Centre and RequestFor - Additional Live Show                             |         201 |
      | Creating request with Division - Entertainment and location - ROCK Centre and RequestFor - Additional Live Show                           |         201 |
      | Creating request with Division - ERG Events and location - ROCK Centre and RequestFor - Additional Live Show                              |         201 |
      | Creating request with Division - Facilities and location - ROCK Centre and RequestFor - Additional Live Show                              |         201 |
      | Creating request with Division - NBC News Studios and location - ROCK Centre and RequestFor - Additional Live Show                        |         201 |
      | Creating request with Division - NBC Sports and location - ROCK Centre and RequestFor - Additional Live Show                              |         201 |
      | Creating request with Division - News Digital and location - ROCK Centre and RequestFor - Additional Live Show                            |         201 |
      | Creating request with Division - Olympics and location - ROCK Centre and RequestFor - Additional Live Show                                |         201 |
      | Creating request with Division - Operations and location - ROCK Centre and RequestFor - Additional Live Show                              |         201 |
      | Creating request with Division - Peacock and location - ROCK Centre and RequestFor - Additional Live Show                                 |         201 |
      | Creating request with Division - Telemundo and location - ROCK Centre and RequestFor - Additional Live Show                               |         201 |
      | Creating request with Division - Universal Kids and location - ROCK Centre and RequestFor - Additional Live Show                          |         201 |
      | Creating request with Division - NBC News and location - ROCK Centre and RequestFor - Pretape Full Show                                   |         201 |
      | Creating request with Division - MSNBC and location - ROCK Centre and RequestFor - Pretape Full Show                                      |         201 |
      | Creating request with Division - CNBC and location - ROCK Centre and RequestFor - Pretape Full Show                                       |         201 |
      | Creating request with Division - Acorn and location - ROCK Centre and RequestFor - Pretape Full Show                                      |         201 |
      | Creating request with Division - Corporate and location - ROCK Centre and RequestFor - Pretape Full Show                                  |         201 |
      | Creating request with Division - Engineering and location - ROCK Centre and RequestFor - Pretape Full Show                                |         201 |
      | Creating request with Division - Entertainment and location - ROCK Centre and RequestFor - Pretape Full Show                              |         201 |
      | Creating request with Division - ERG Events and location - ROCK Centre and RequestFor - Pretape Full Show                                 |         201 |
      | Creating request with Division - Facilities and location - ROCK Centre and RequestFor - Pretape Full Show                                 |         201 |
      | Creating request with Division - NBC News Studios and location - ROCK Centre and RequestFor - Pretape Full Show                           |         201 |
      | Creating request with Division - NBC Sports and location - ROCK Centre and RequestFor - Pretape Full Show                                 |         201 |
      | Creating request with Division - News Digital and location - ROCK Centre and RequestFor - Pretape Full Show                               |         201 |
      | Creating request with Division - Olympics and location - ROCK Centre and RequestFor - Pretape Full Show                                   |         201 |
      | Creating request with Division - Operations and location - ROCK Centre and RequestFor - Pretape Full Show                                 |         201 |
      | Creating request with Division - Peacock and location - ROCK Centre and RequestFor - Pretape Full Show                                    |         201 |
      | Creating request with Division - Telemundo and location - ROCK Centre and RequestFor - Pretape Full Show                                  |         201 |
      | Creating request with Division - Universal Kids and location - ROCK Centre and RequestFor - Pretape Full Show                             |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor -  Musical Performance]                                    |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor -  Musical Performance]                                       |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor -  Musical Performance]                                        |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor -  Musical Performance]                                      |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor -  Musical Performance]                                 |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor -  Musical Performance]                               |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor -  Musical Performance]                             |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor -  Musical Performance]                                |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor -  Musical Performance]                                |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor -  Musical Performance]                          |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor -  Musical Performance]                                |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor -  Musical Performance]                              |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor -  Musical Performance]                                  |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor -  Musical Performance]                                |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor -  Musical Performance]                                   |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor -  Musical Performance]                                 |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor -  Musical Performance]                            |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                           |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                              |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                               |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                             |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                        |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                      |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                    |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                       |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                       |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                 |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                       |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                     |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                         |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                       |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                          |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                        |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor -  Podcast Recording/Radio Show]                   |         201 |
      | Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Other]                                                   |         201 |
      | Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Other]                                                      |         201 |
      | Creating request with [Division - CNBC, location - ROCK Centre, RequestFor - Other]                                                       |         201 |
      | Creating request with [Division - Acorn,  location - ROCK Centre, RequestFor - Other]                                                     |         201 |
      | Creating request with [Division - Corporate ,  location - ROCK Centre, RequestFor - Other]                                                |         201 |
      | Creating request with [Division - Engineering ,  location - ROCK Centre, RequestFor - Other]                                              |         201 |
      | Creating request with [Division - Entertainment ,  location - ROCK Centre, RequestFor - Other]                                            |         201 |
      | Creating request with [Division - ERG Events ,  location - ROCK Centre, RequestFor - Other]                                               |         201 |
      | Creating request with [Division - Facilities ,  location - ROCK Centre, RequestFor - Other]                                               |         201 |
      | Creating request with [Division - NBC News Studios ,  location - ROCK Centre, RequestFor - Other]                                         |         201 |
      | Creating request with [Division - NBC Sports ,  location - ROCK Centre, RequestFor - Other]                                               |         201 |
      | Creating request with [Division - News Digital ,  location - ROCK Centre, RequestFor - Other]                                             |         201 |
      | Creating request with [Division - Olympics ,  location - ROCK Centre, RequestFor - Other]                                                 |         201 |
      | Creating request with [Division - Operations ,  location - ROCK Centre, RequestFor - Other]                                               |         201 |
      | Creating request with [Division - Peacock ,  location - ROCK Centre, RequestFor - Other]                                                  |         201 |
      | Creating request with [Division - Telemundo ,  location - ROCK Centre, RequestFor - Other]                                                |         201 |
      | Creating request with [Division - Universal Kids ,  location - ROCK Centre, RequestFor - Other]                                           |         201 |
      #============ To Verify Rock Center Production Request creation with Air Platforms ==============================
      | Creating request with Air Platform - OTT                                                                                                  |         201 |
      | Creating request with Air Platform - Broadcast                                                                                            |         201 |
      | Creating request with Air Platform - Cable                                                                                                |         201 |
      | Creating request with Air Platform - N/A                                                                                                  |         201 |
      | Creating request with Air Platform - Internal                                                                                             |         201 |
      | Creating request with Air Platform - Video Conference                                                                                     |         201 |
      | Creating request with Air Platform - Multiple                                                                                             |         201 |

  Scenario Outline: To verify negative scenarios
    When user set up headers
      | Content-Type | application/Json |
      | messageid    | sdsddsd12        |
      | userId       | en               |
    #service in config and sheet name should be same
    And user read data "<scenario_name>" and create payload for "Create_Studio_Prod_Req"
    Then user invokes "Create_Studio_Prod_Req" service to create new request
      """

      """
    Then validate the status code "<status_code>"

    Examples: 
      | scenario_name                                                                  | status_code |
      | Creating request with mandatory fields null and non  mandatory fields not null |         400 |
