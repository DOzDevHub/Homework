Homework task for Policy premium calculation.

#request body Jsons:
```json
{
	"number": "LV19-07-100000-1",
	"policyStatus": "REGISTERED",
	"premium": 0,
	"policyTargets" : [
		{
			"name": "Flat",
			"policyItems" : [
				{
					"name": "TV",
					"sumInsured": 8,
					"riskType": "WATER"
				},
				{
					"name": "Property",
					"sumInsured": 100,
					"riskType": "FIRE"
				}
			]
		}
		
	]
}
```

```json
{
	"number": "LV19-07-100000-1",
	"policyStatus": "REGISTERED",
	"premium": 0,
	"policyTargets" : [
		{
			"name": "Flat",
			"policyItems" : [
				{
					"name": "TV",
					"sumInsured": 100,
					"riskType": "WATER"
				},
				{
					"name": "Property",
					"sumInsured": 500,
					"riskType": "FIRE"
				}
			]
		}
		
	]
}
```