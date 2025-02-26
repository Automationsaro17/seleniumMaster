@ResourceValidation @CrewRequest @ProducerDashboard
Feature: Validate various scenarios related NBC News Crew Request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @NBCNewsCrewRequest_ResourceValidation
  Scenario Outline: Verify user filling NBC News Crew Request form for Resource Validation
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in NBC News Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in NBC News Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in NBC News Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in NBC News Crew form
      | Production Type   | Shoot Status | Shoot Description   |
      | <Production Type> | Tent         | test/tesr/test/test |
    When user enters shoot specs Information in NBC News Crew form
      | Audio Needs   | Special Conditions   | Transmission Type | Acquisition Specs | Is this a Drone Shoot | Special Gear |
      | <Audio Needs> | <Special Conditions> | LIVEU             | Broadcast/Tape    | No                    | No           |
    Then Verify suggested resource based on combination of Production Type,Audio Needs,Special Conditions
      | Resource   |
      | <Resource> |
    And user logs out from application

    Examples: 
      | Form Name | Production Type                      | Audio Needs            | Special Conditions                 | Resource        |
      | NBC News  | TAPE - Phone Interview               | 1-2 Audio Sources      | High profile guest                 | OMB             |
      | NBC News  | TAPE - Phone Interview               | 1-2 Audio Sources      | Additional/complex lighting        | OMB             |
      | NBC News  | TAPE - Phone Interview               | 1-2 Audio Sources      | Time constraints                   | OMB             |
      | NBC News  | TAPE - Phone Interview               | 1-2 Audio Sources      | Weather concern                    | OMB             |
      | NBC News  | TAPE - Phone Interview               | 1-2 Audio Sources      | Safety/security concern            | OMB             |
      | NBC News  | TAPE - Phone Interview               | 1-2 Audio Sources      | Large disaster/Major breaking news | OMB             |
      | NBC News  | TAPE - Phone Interview               | Complex Audio          | High profile guest                 | OMB             |
      | NBC News  | TAPE - Phone Interview               | Complex Audio          | Additional/complex lighting        | OMB             |
      | NBC News  | TAPE - Phone Interview               | Complex Audio          | Time constraints                   | OMB             |
      | NBC News  | TAPE - Phone Interview               | Complex Audio          | Weather concern                    | OMB             |
      | NBC News  | TAPE - Phone Interview               | Complex Audio          | Safety/security concern            | OMB             |
      | NBC News  | TAPE - Phone Interview               | Complex Audio          | Large disaster/Major breaking news | OMB             |
      | NBC News  | TAPE - BRoll                         | 1-2 Audio Sources      | High profile guest                 | OMB             |
      | NBC News  | TAPE - BRoll                         | 1-2 Audio Sources      | Additional/complex lighting        | OMB             |
      | NBC News  | TAPE - BRoll                         | 1-2 Audio Sources      | Time constraints                   | OMB             |
      | NBC News  | TAPE - BRoll                         | 1-2 Audio Sources      | Weather concern                    | OMB             |
      | NBC News  | TAPE - BRoll                         | 1-2 Audio Sources      | Safety/security concern            | OMB             |
      | NBC News  | TAPE - BRoll                         | 1-2 Audio Sources      | Large disaster/Major breaking news | OMB             |
      | NBC News  | TAPE - MOS                           | 1-2 Audio Sources      | High profile guest                 | FULL CREW       |
      | NBC News  | TAPE - MOS                           | 1-2 Audio Sources      | Additional/complex lighting        | FULL CREW       |
      | NBC News  | TAPE - MOS                           | 1-2 Audio Sources      | Time constraints                   | FULL CREW       |
      | NBC News  | TAPE - MOS                           | 1-2 Audio Sources      | Weather concern                    | FULL CREW       |
      | NBC News  | TAPE - MOS                           | 1-2 Audio Sources      | Safety/security concern            | FULL CREW       |
      | NBC News  | TAPE - MOS                           | 1-2 Audio Sources      | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | TAPE - MOS                           | 1-2 Audio Sources      | High profile guest                 | FULL CREW       |
      | NBC News  | TAPE - MOS                           | 1-2 Audio Sources      | Additional/complex lighting        | FULL CREW       |
      | NBC News  | TAPE - MOS                           | 1-2 Audio Sources      | Time constraints                   | FULL CREW       |
      | NBC News  | TAPE - MOS                           | 1-2 Audio Sources      | Weather concern                    | FULL CREW       |
      | NBC News  | TAPE - MOS                           | 1-2 Audio Sources      | Safety/security concern            | FULL CREW       |
      | NBC News  | TAPE - MOS                           | 1-2 Audio Sources      | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 1-2 Audio Sources      | High profile guest                 | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 1-2 Audio Sources      | Additional/complex lighting        | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 1-2 Audio Sources      | Time constraints                   | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 1-2 Audio Sources      | Weather concern                    | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 1-2 Audio Sources      | Safety/security concern            | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 1-2 Audio Sources      | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 3-4 Audio Sources      | High profile guest                 | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 3-4 Audio Sources      | Additional/complex lighting        | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 3-4 Audio Sources      | Time constraints                   | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 3-4 Audio Sources      | Weather concern                    | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 3-4 Audio Sources      | Safety/security concern            | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 3-4 Audio Sources      | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 5+ Audio Sources/Panel | High profile guest                 | 2 FULL CREWS    |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 5+ Audio Sources/Panel | Additional/complex lighting        | 2 FULL CREWS    |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 5+ Audio Sources/Panel | Time constraints                   | 2 FULL CREWS    |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 5+ Audio Sources/Panel | Weather concern                    | 2 FULL CREWS    |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 5+ Audio Sources/Panel | Safety/security concern            | 2 FULL CREWS    |
      | NBC News  | TAPE - Interview (Multiple Subjects) | 5+ Audio Sources/Panel | Large disaster/Major breaking news | 2 FULL CREWS    |
      | NBC News  | TAPE - Interview (Multiple Subjects) | Complex Audio          | High profile guest                 | FULL CREW + OMB |
      | NBC News  | TAPE - Interview (Multiple Subjects) | Complex Audio          | Additional/complex lighting        | FULL CREW + OMB |
      | NBC News  | TAPE - Interview (Multiple Subjects) | Complex Audio          | Time constraints                   | FULL CREW + OMB |
      | NBC News  | TAPE - Interview (Multiple Subjects) | Complex Audio          | Weather concern                    | FULL CREW + OMB |
      | NBC News  | TAPE - Interview (Multiple Subjects) | Complex Audio          | Safety/security concern            | FULL CREW + OMB |
      | NBC News  | TAPE - Interview (Multiple Subjects) | Complex Audio          | Large disaster/Major breaking news | FULL CREW + OMB |
      | NBC News  | TAPE - Interview 1on1                | 1-2 Audio Sources      | High profile guest                 | FULL CREW       |
      | NBC News  | TAPE - Interview 1on1                | 1-2 Audio Sources      | Additional/complex lighting        | FULL CREW       |
      | NBC News  | TAPE - Interview 1on1                | 1-2 Audio Sources      | Time constraints                   | OMB             |
      | NBC News  | TAPE - Interview 1on1                | 1-2 Audio Sources      | Weather concern                    | FULL CREW       |
      | NBC News  | TAPE - Interview 1on1                | 1-2 Audio Sources      | Safety/security concern            | FULL CREW       |
      | NBC News  | TAPE - Interview 1on1                | 1-2 Audio Sources      | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | TAPE - Interview 1on1                | Complex Audio          | High profile guest                 | FULL CREW       |
      | NBC News  | TAPE - Interview 1on1                | Complex Audio          | Additional/complex lighting        | FULL CREW       |
      | NBC News  | TAPE - Interview 1on1                | Complex Audio          | Time constraints                   | FULL CREW       |
      | NBC News  | TAPE - Interview 1on1                | Complex Audio          | Weather concern                    | FULL CREW       |
      | NBC News  | TAPE - Interview 1on1                | Complex Audio          | Safety/security concern            | FULL CREW       |
      | NBC News  | TAPE - Interview 1on1                | Complex Audio          | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | 1-2 Audio Sources      | High profile guest                 | OMB             |
      | NBC News  | LIVE - Correspondent                 | 1-2 Audio Sources      | Additional/complex lighting        | OMB             |
      | NBC News  | LIVE - Correspondent                 | 1-2 Audio Sources      | Time constraints                   | OMB             |
      | NBC News  | LIVE - Correspondent                 | 1-2 Audio Sources      | Weather concern                    | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | 1-2 Audio Sources      | Safety/security concern            | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | 1-2 Audio Sources      | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | 3-4 Audio Sources      | High profile guest                 | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | 3-4 Audio Sources      | Additional/complex lighting        | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | 3-4 Audio Sources      | Time constraints                   | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | 3-4 Audio Sources      | Weather concern                    | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | 3-4 Audio Sources      | Safety/security concern            | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | 3-4 Audio Sources      | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | Complex Audio          | High profile guest                 | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | Complex Audio          | Additional/complex lighting        | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | Complex Audio          | Time constraints                   | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | Complex Audio          | Weather concern                    | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | Complex Audio          | Safety/security concern            | FULL CREW       |
      | NBC News  | LIVE - Correspondent                 | Complex Audio          | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 1-2 Audio Sources      | High profile guest                 | OMB             |
      | NBC News  | LIVE - GUEST                         | 1-2 Audio Sources      | Additional/complex lighting        | OMB             |
      | NBC News  | LIVE - GUEST                         | 1-2 Audio Sources      | Time constraints                   | OMB             |
      | NBC News  | LIVE - GUEST                         | 1-2 Audio Sources      | Weather concern                    | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 1-2 Audio Sources      | Safety/security concern            | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 1-2 Audio Sources      | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 3-4 Audio Sources      | High profile guest                 | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 3-4 Audio Sources      | Additional/complex lighting        | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 3-4 Audio Sources      | Time constraints                   | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 3-4 Audio Sources      | Weather concern                    | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 3-4 Audio Sources      | Safety/security concern            | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 3-4 Audio Sources      | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 5+ Audio Sources/Panel | High profile guest                 | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 5+ Audio Sources/Panel | Additional/complex lighting        | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 5+ Audio Sources/Panel | Time constraints                   | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 5+ Audio Sources/Panel | Weather concern                    | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 5+ Audio Sources/Panel | Safety/security concern            | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | 5+ Audio Sources/Panel | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | Complex Audio          | High profile guest                 | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | Complex Audio          | Additional/complex lighting        | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | Complex Audio          | Time constraints                   | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | Complex Audio          | Weather concern                    | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | Complex Audio          | Safety/security concern            | FULL CREW       |
      | NBC News  | LIVE - GUEST                         | Complex Audio          | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | LIVE - Presser                       | 1-2 Audio Sources      | High profile guest                 | OMB             |
      | NBC News  | LIVE - Presser                       | 1-2 Audio Sources      | Additional/complex lighting        | OMB             |
      | NBC News  | LIVE - Presser                       | 1-2 Audio Sources      | Time constraints                   | OMB             |
      | NBC News  | LIVE - Presser                       | 1-2 Audio Sources      | Weather concern                    | FULL CREW       |
      | NBC News  | LIVE - Presser                       | 1-2 Audio Sources      | Safety/security concern            | FULL CREW       |
      | NBC News  | LIVE - Presser                       | 1-2 Audio Sources      | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | LIVE - Presser                       | Complex Audio          | High profile guest                 | OMB             |
      | NBC News  | LIVE - Presser                       | Complex Audio          | Additional/complex lighting        | OMB             |
      | NBC News  | LIVE - Presser                       | Complex Audio          | Time constraints                   | OMB             |
      | NBC News  | LIVE - Presser                       | Complex Audio          | Weather concern                    | FULL CREW       |
      | NBC News  | LIVE - Presser                       | Complex Audio          | Safety/security concern            | FULL CREW       |
      | NBC News  | LIVE - Presser                       | Complex Audio          | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | LIVE - Anchor                        | 1-2 Audio Sources      | High profile guest                 | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 1-2 Audio Sources      | Additional/complex lighting        | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 1-2 Audio Sources      | Time constraints                   | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 1-2 Audio Sources      | Weather concern                    | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 1-2 Audio Sources      | Safety/security concern            | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 1-2 Audio Sources      | Large disaster/Major breaking news | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 3-4 Audio Sources      | High profile guest                 | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 3-4 Audio Sources      | Additional/complex lighting        | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 3-4 Audio Sources      | Time constraints                   | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 3-4 Audio Sources      | Weather concern                    | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 3-4 Audio Sources      | Safety/security concern            | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 3-4 Audio Sources      | Large disaster/Major breaking news | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 5+ Audio Sources/Panel | High profile guest                 | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 5+ Audio Sources/Panel | Additional/complex lighting        | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 5+ Audio Sources/Panel | Time constraints                   | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 5+ Audio Sources/Panel | Weather concern                    | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 5+ Audio Sources/Panel | Safety/security concern            | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | 5+ Audio Sources/Panel | Large disaster/Major breaking news | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | Complex Audio          | High profile guest                 | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | Complex Audio          | Additional/complex lighting        | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | Complex Audio          | Time constraints                   | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | Complex Audio          | Weather concern                    | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | Complex Audio          | Safety/security concern            | 2 FULL CREWS    |
      | NBC News  | LIVE - Anchor                        | Complex Audio          | Large disaster/Major breaking news | 2 FULL CREWS    |
      | NBC News  | LIVE - Bureau Cam                    | 1-2 Audio Sources      | High profile guest                 | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 1-2 Audio Sources      | Additional/complex lighting        | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 1-2 Audio Sources      | Time constraints                   | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 1-2 Audio Sources      | Weather concern                    | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 1-2 Audio Sources      | Safety/security concern            | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 1-2 Audio Sources      | Large disaster/Major breaking news | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 3-4 Audio Sources      | High profile guest                 | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 3-4 Audio Sources      | Additional/complex lighting        | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 3-4 Audio Sources      | Time constraints                   | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 3-4 Audio Sources      | Weather concern                    | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 3-4 Audio Sources      | Safety/security concern            | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 3-4 Audio Sources      | Large disaster/Major breaking news | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 5+ Audio Sources/Panel | High profile guest                 | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 5+ Audio Sources/Panel | Additional/complex lighting        | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 5+ Audio Sources/Panel | Time constraints                   | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 5+ Audio Sources/Panel | Weather concern                    | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 5+ Audio Sources/Panel | Safety/security concern            | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | 5+ Audio Sources/Panel | Large disaster/Major breaking news | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | Complex Audio          | High profile guest                 | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | Complex Audio          | Additional/complex lighting        | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | Complex Audio          | Time constraints                   | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | Complex Audio          | Weather concern                    | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | Complex Audio          | Safety/security concern            | OMB             |
      | NBC News  | LIVE - Bureau Cam                    | Complex Audio          | Large disaster/Major breaking news | OMB             |
      | NBC News  | Home Studio                          | 1-2 Audio Sources      | High profile guest                 | OMB             |
      | NBC News  | Home Studio                          | 1-2 Audio Sources      | Additional/complex lighting        | OMB             |
      | NBC News  | Home Studio                          | 1-2 Audio Sources      | Time constraints                   | OMB             |
      | NBC News  | Home Studio                          | 1-2 Audio Sources      | Weather concern                    | OMB             |
      | NBC News  | Home Studio                          | 1-2 Audio Sources      | Safety/security concern            | OMB             |
      | NBC News  | Home Studio                          | 1-2 Audio Sources      | Large disaster/Major breaking news | OMB             |
      | NBC News  | Home Studio                          | 3-4 Audio Sources      | High profile guest                 | OMB             |
      | NBC News  | Home Studio                          | 3-4 Audio Sources      | Additional/complex lighting        | OMB             |
      | NBC News  | Home Studio                          | 3-4 Audio Sources      | Time constraints                   | OMB             |
      | NBC News  | Home Studio                          | 3-4 Audio Sources      | Weather concern                    | OMB             |
      | NBC News  | Home Studio                          | 3-4 Audio Sources      | Safety/security concern            | OMB             |
      | NBC News  | Home Studio                          | 3-4 Audio Sources      | Large disaster/Major breaking news | OMB             |
      | NBC News  | Home Studio                          | 5+ Audio Sources/Panel | High profile guest                 | OMB             |
      | NBC News  | Home Studio                          | 5+ Audio Sources/Panel | Additional/complex lighting        | OMB             |
      | NBC News  | Home Studio                          | 5+ Audio Sources/Panel | Time constraints                   | OMB             |
      | NBC News  | Home Studio                          | 5+ Audio Sources/Panel | Weather concern                    | OMB             |
      | NBC News  | Home Studio                          | 5+ Audio Sources/Panel | Safety/security concern            | OMB             |
      | NBC News  | Home Studio                          | 5+ Audio Sources/Panel | Large disaster/Major breaking news | OMB             |
      | NBC News  | Home Studio                          | Complex Audio          | High profile guest                 | OMB             |
      | NBC News  | Home Studio                          | Complex Audio          | Additional/complex lighting        | OMB             |
      | NBC News  | Home Studio                          | Complex Audio          | Time constraints                   | OMB             |
      | NBC News  | Home Studio                          | Complex Audio          | Weather concern                    | OMB             |
      | NBC News  | Home Studio                          | Complex Audio          | Safety/security concern            | OMB             |
      | NBC News  | Home Studio                          | Complex Audio          | Large disaster/Major breaking news | OMB             |
      | NBC News  | BREAKING NEWS                        | 1-2 Audio Sources      | High profile guest                 | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 1-2 Audio Sources      | Additional/complex lighting        | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 1-2 Audio Sources      | Time constraints                   | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 1-2 Audio Sources      | Weather concern                    | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 1-2 Audio Sources      | Safety/security concern            | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 1-2 Audio Sources      | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 3-4 Audio Sources      | High profile guest                 | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 3-4 Audio Sources      | Additional/complex lighting        | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 3-4 Audio Sources      | Time constraints                   | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 3-4 Audio Sources      | Weather concern                    | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 3-4 Audio Sources      | Safety/security concern            | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 3-4 Audio Sources      | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 5+ Audio Sources/Panel | High profile guest                 | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 5+ Audio Sources/Panel | Additional/complex lighting        | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 5+ Audio Sources/Panel | Time constraints                   | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 5+ Audio Sources/Panel | Weather concern                    | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 5+ Audio Sources/Panel | Safety/security concern            | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | 5+ Audio Sources/Panel | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | Complex Audio          | High profile guest                 | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | Complex Audio          | Additional/complex lighting        | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | Complex Audio          | Time constraints                   | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | Complex Audio          | Weather concern                    | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | Complex Audio          | Safety/security concern            | FULL CREW       |
      | NBC News  | BREAKING NEWS                        | Complex Audio          | Large disaster/Major breaking news | FULL CREW       |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 1-2 Audio Sources      | High profile guest                 | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 1-2 Audio Sources      | Additional/complex lighting        | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 1-2 Audio Sources      | Time constraints                   | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 1-2 Audio Sources      | Weather concern                    | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 1-2 Audio Sources      | Safety/security concern            | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 1-2 Audio Sources      | Large disaster/Major breaking news | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 3-4 Audio Sources      | High profile guest                 | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 3-4 Audio Sources      | Additional/complex lighting        | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 3-4 Audio Sources      | Time constraints                   | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 3-4 Audio Sources      | Weather concern                    | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 3-4 Audio Sources      | Safety/security concern            | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 3-4 Audio Sources      | Large disaster/Major breaking news | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 5+ Audio Sources/Panel | High profile guest                 | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 5+ Audio Sources/Panel | Additional/complex lighting        | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 5+ Audio Sources/Panel | Time constraints                   | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 5+ Audio Sources/Panel | Weather concern                    | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 5+ Audio Sources/Panel | Safety/security concern            | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | 5+ Audio Sources/Panel | Large disaster/Major breaking news | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | Complex Audio          | High profile guest                 | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | Complex Audio          | Additional/complex lighting        | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | Complex Audio          | Time constraints                   | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | Complex Audio          | Weather concern                    | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | Complex Audio          | Safety/security concern            | NO CREW         |
      | NBC News  | Remote Interview - Zoom, Skype, etc. | Complex Audio          | Large disaster/Major breaking news | NO CREW         |
      | NBC News  | FIELD EDIT                           | 1-2 Audio Sources      | High profile guest                 | OMB             |
      | NBC News  | FIELD EDIT                           | 1-2 Audio Sources      | Additional/complex lighting        | OMB             |
      | NBC News  | FIELD EDIT                           | 1-2 Audio Sources      | Time constraints                   | OMB             |
      | NBC News  | FIELD EDIT                           | 1-2 Audio Sources      | Weather concern                    | OMB             |
      | NBC News  | FIELD EDIT                           | 1-2 Audio Sources      | Safety/security concern            | OMB             |
      | NBC News  | FIELD EDIT                           | 1-2 Audio Sources      | Large disaster/Major breaking news | OMB             |
      | NBC News  | FIELD EDIT                           | 3-4 Audio Sources      | High profile guest                 | OMB             |
      | NBC News  | FIELD EDIT                           | 3-4 Audio Sources      | Additional/complex lighting        | OMB             |
      | NBC News  | FIELD EDIT                           | 3-4 Audio Sources      | Time constraints                   | OMB             |
      | NBC News  | FIELD EDIT                           | 3-4 Audio Sources      | Weather concern                    | OMB             |
      | NBC News  | FIELD EDIT                           | 3-4 Audio Sources      | Safety/security concern            | OMB             |
      | NBC News  | FIELD EDIT                           | 3-4 Audio Sources      | Large disaster/Major breaking news | OMB             |
      | NBC News  | FIELD EDIT                           | 5+ Audio Sources/Panel | High profile guest                 | OMB             |
      | NBC News  | FIELD EDIT                           | 5+ Audio Sources/Panel | Additional/complex lighting        | OMB             |
      | NBC News  | FIELD EDIT                           | 5+ Audio Sources/Panel | Time constraints                   | OMB             |
      | NBC News  | FIELD EDIT                           | 5+ Audio Sources/Panel | Weather concern                    | OMB             |
      | NBC News  | FIELD EDIT                           | 5+ Audio Sources/Panel | Safety/security concern            | OMB             |
      | NBC News  | FIELD EDIT                           | 5+ Audio Sources/Panel | Large disaster/Major breaking news | OMB             |
      | NBC News  | FIELD EDIT                           | Complex Audio          | High profile guest                 | OMB             |
      | NBC News  | FIELD EDIT                           | Complex Audio          | Additional/complex lighting        | OMB             |
      | NBC News  | FIELD EDIT                           | Complex Audio          | Time constraints                   | OMB             |
      | NBC News  | FIELD EDIT                           | Complex Audio          | Weather concern                    | OMB             |
      | NBC News  | FIELD EDIT                           | Complex Audio          | Safety/security concern            | OMB             |
      | NBC News  | FIELD EDIT                           | Complex Audio          | Large disaster/Major breaking news | OMB             |
