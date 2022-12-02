# Description

> **tolkein** - because all this talk of Guilds and Tribes makes me think of Hobbits.

I wanted a way (not a Spreadsheet) to very quickly create a Spotify model for resourcing. At work, I have to resource 
Squads with different profile needs, so I often find myself asking questions such as:

- who has Java experience but has worked with X or Y person recently
- who is the Payments team could be supported to work on ColdFusion code based on close working relationships with an 
experienced developer

Goals where:
- explore the benefits of a GraphDB to map relationships rather than entities
- explore SpringDataRest a bit more - i.e. how can repository methods be customised to create something a bit better 
than what you get from the  "out the box" configuration
- write the whole thing in Kotlin to get a sense of how different it is for SpringBoot
- use Gradle as the build (because why not if you are going to be experimenting)

## The Data Model - GraphDB

### The basics...

My first aim was to capture the basic entities of the Spotify model

- ``Person``
- ``Squad``
- ``Tribe``
- ``Guild``
- ``Chapter``

At the root of the model is the Entity ``Person``. The entities I am interested in are ``Software Engineer`` resources. 

A ``Person`` can be a ``MEMBER_OF`` a ``Squad``, which in turn is ``PART_OF`` a ``TRIBE``.

In addition to members, a ``Squad`` will have a dedicated ``PRODUCT_OWNER``; a ``Tribe`` will have a dedicated 
``TRIBE_LEAD``.

<img src="screenshots/Labels.png" style="width:50%;display:block;margin-left:auto;margin-right:auto;border-radius:12px">

In the Spotify model, the ``Squad`` is an autonomous organisational unit. However, members will each have their own 
job specialism. A ``Chapter`` is responsible for technical leadership and engineering standards for a specific job and 
will be ``LED_BY`` a senior technical resource.

<img src="screenshots/Chapters.png" style="width:50%;display:block;margin-left:auto;margin-right:auto;border-radius:12px">

A ``Guild`` is a community of interest for a particular technology or topic. Any ``Person`` can join a ``Guild`` and 
there is no formal structure except for a ``COORDINATOR``.

<img src="screenshots/Guilds.png" style="width:50%;display:block;margin-left:auto;margin-right:auto;border-radius:12px">

### Next level...

In order to answer questions about which skills an Engineer has I created a Skill entity for each skill and then added
appropriate relationships

<img src="screenshots/Skills.png" style="width:50%;display:block;margin-left:auto;margin-right:auto;border-radius:12px">

# Installation

``./gradlew bootRun``

# Usage

What do you want me to tell you? It's a HAL-based REST API - ``curl`` away!