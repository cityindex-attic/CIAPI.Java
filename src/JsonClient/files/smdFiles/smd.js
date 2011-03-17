﻿{
    "SMDVersion": "2.6",
    "version": "1",
    "id": "http://ciapipreprod.cityindextest9.co.uk/TradingApi/smd.js?includeDemoValue=true",
    "target": "http://ciapipreprod.cityindextest9.co.uk/TradingApi/",
    "schema": "http://ciapipreprod.cityindextest9.co.uk/TradingApi/schema?includeDemoValue=true",
    "description": "City Index RESTful API 1",
    "additionalParameters": true,
    "services": {
        "CreateSession": {
            "description": "Create a new session. The is how you \"log on\" to the CIAPI.",
            "target": "session",
            "uriTemplate": "/",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "POST",
            "envelope": "JSON",
            "returns": {
                "$ref": "#.CreateSessionResponseDTO"
            },
            "group": "Authentication",
            "throttleScope": "data",
            "parameters": [
        {
            "type": "string",
            "name": "UserName",
            "description": "Username is case sensitive",
            "demoValue": "CC735158",
            "minLength": 6,
            "maxLength": 20
        },
        {
            "type": "string",
            "name": "Password",
            "description": "Password is case sensitive",
            "demoValue": "password",
            "minLength": 6,
            "maxLength": 20
        }
      ]
        },
        "DeleteSession": {
            "description": "Delete a session. This is how you \"log off\" from the CIAPI.",
            "target": "session",
            "uriTemplate": "/deleteSession?userName={userName}&session={session}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "POST",
            "envelope": "JSON",
            "returns": {
                "$ref": "#.SessionDeletionResponseDTO"
            },
            "group": "Authentication",
            "throttleScope": "data",
            "parameters": [
        {
            "type": "string",
            "name": "userName",
            "description": "Username is case sensitive. May be set as a service parameter or as a request header.",
            "demoValue": "CC735158",
            "minLength": 6,
            "maxLength": 20
        },
        {
            "type": "string",
            "name": "session",
            "description": "The session token. May be set as a service parameter or as a request header.",
            "demoValue": "5998CBE8-3594-4232-A57E-09EC3A4E7AA8",
            "format": "guid",
            "minLength": 36,
            "maxLength": 36
        }
      ]
        },
        "GetPriceBars": {
            "description": "Get historic price bars in OHLC (open, high, low, close) format, suitable for plotting candlestick chartsReturns price bars in ascending order up to the current time.When there are no prices per a particular time period, no price bar is returned. Thus, it can appear that the array of price bars has \"gaps\", i.e. the gap between the datetime of each price bar might not be equal to interval x spanSample Urls: /market/1234/history?interval=MINUTE&span=15&pricebars=180/market/735/history?interval=HOUR&span=1&pricebars=240/market/1577/history?interval=DAY&span=1&pricebars=10",
            "target": "market",
            "uriTemplate": "/{marketId}/barhistory?interval={interval}&span={span}&pricebars={priceBars}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.GetPriceBarResponseDTO"
            },
            "group": "Price History",
            "cacheDuration": 10000,
            "throttleScope": "data",
            "parameters": [
        {
            "type": "string",
            "name": "marketId",
            "description": "The marketId",
            "demoValue": "71442"
        },
        {
            "type": "string",
            "name": "interval",
            "description": "The pricebar interval",
            "demoValue": "MINUTE"
        },
        {
            "type": "integer",
            "name": "span",
            "description": "The number of each interval per pricebar.",
            "demoValue": 1
        },
        {
            "type": "string",
            "name": "priceBars",
            "description": "The total number of pricebars to return",
            "demoValue": "15"
        }
      ]
        },
        "GetPriceTicks": {
            "description": "Get historic price ticks. Returns price ticks in ascending order up to the current time. The length of time between each tick will be different.",
            "target": "market",
            "uriTemplate": "/{marketId}/tickhistory?priceticks={priceTicks}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.GetPriceTickResponseDTO"
            },
            "group": "Price History",
            "cacheDuration": 10000,
            "throttleScope": "data",
            "parameters": [
        {
            "type": "string",
            "name": "marketId",
            "description": "The marketId",
            "demoValue": "71442"
        },
        {
            "type": "string",
            "name": "priceTicks",
            "description": "The total number of price ticks to return",
            "demoValue": "10"
        }
      ]
        },
        "GetMarketInformation": {
            "description": "Get Market Information for the specified market.",
            "target": "market",
            "uriTemplate": "/{marketId}/information",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.MarketInformationResponseDTO"
            },
            "group": "Market",
            "throttleScope": "data",
            "parameters": [
        {
            "type": "string",
            "name": "marketId",
            "description": "The marketId",
            "demoValue": "71442"
        }
      ]
        },
        "ListNewsHeadlines": {
            "description": "Get a list of current news headlines",
            "target": "news",
            "uriTemplate": "?Category={category}&MaxResults={maxResults}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.ListNewsHeadlinesResponseDTO"
            },
            "group": "News",
            "cacheDuration": 10000,
            "throttleScope": "data",
            "parameters": [
        {
            "type": "string",
            "name": "category",
            "description": "Filter headlines by category",
            "demoValue": "UK",
            "minLength": 2,
            "maxLength": 3
        },
        {
            "type": "integer",
            "name": "maxResults",
            "description": "Restrict the number of headlines returned",
            "demoValue": 10,
            "default": 25,
            "minimum": 1,
            "maximum": 500
        }
      ]
        },
        "GetNewsDetail": {
            "description": "Get the detail of a specific news story",
            "target": "news",
            "uriTemplate": "/{storyId}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.GetNewsDetailResponseDTO"
            },
            "group": "News",
            "cacheDuration": 10000,
            "throttleScope": "data",
            "parameters": [
        {
            "type": "string",
            "name": "storyId",
            "description": "The news story Id",
            "demoValue": "12654",
            "minLength": 1,
            "maxLength": 9
        }
      ]
        },
        "ListCfdMarkets": {
            "description": "Returns a list of CFD markets filtered by market name and/or market code",
            "target": "cfd/markets",
            "uriTemplate": "?MarketName={searchByMarketName}&MarketCode={searchByMarketCode}&ClientAccountId={clientAccountId}&MaxResults={maxResults}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.ListCfdMarketsResponseDTO"
            },
            "group": "CFD Markets",
            "throttleScope": "data",
            "parameters": [
        {
            "type": "string",
            "name": "searchByMarketName",
            "description": "The characters that the CFD market name should start with",
            "demoValue": "voda",
            "minLength": 1,
            "maxLength": 120
        },
        {
            "type": "string",
            "name": "searchByMarketCode",
            "description": "The characters that the market code should start with (normally this is the RIC code for the market)",
            "minLength": 1,
            "maxLength": 50
        },
        {
            "type": "integer",
            "name": "clientAccountId",
            "description": "The logged on user's ClientAccountId.  (This only shows you markets that you can trade on)",
            "demoValue": 123456,
            "minimum": 1,
            "maximum": 2147483647,
            "required": true
        },
        {
            "type": "integer",
            "name": "maxResults",
            "description": "The maximum number of markets to return.",
            "demoValue": 20,
            "minimum": 1,
            "maximum": 500,
            "default": 20
        }
      ]
        },
        "ListSpreadMarkets": {
            "description": "Returns a list of Spread Betting markets filtered by market name and/or market code",
            "target": "spread/markets",
            "uriTemplate": "?MarketName={searchByMarketName}&MarketCode={searchByMarketCode}&ClientAccountId={clientAccountId}&MaxResults={maxResults}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.ListSpreadMarketsResponseDTO"
            },
            "group": "Spread Markets",
            "cacheDuration": 10000,
            "throttleScope": "data",
            "parameters": [
        {
            "type": "string",
            "name": "searchByMarketName",
            "description": "The characters that the Spread market name should start with",
            "demoValue": "voda",
            "minLength": 1,
            "maxLength": 120
        },
        {
            "type": "string",
            "name": "searchByMarketCode",
            "description": "The characters that the Spread market code should start with (normally this is the RIC code for the market)",
            "demoValue": "VOD.L",
            "minLength": 1,
            "maxLength": 50
        },
        {
            "type": "integer",
            "name": "clientAccountId",
            "description": "The logged on user's ClientAccountId.  (This only shows you markets that you can trade on)",
            "demoValue": 123456,
            "minimum": 1,
            "maximum": 84272157
        },
        {
            "type": "integer",
            "name": "maxResults",
            "description": "The maximum number of markets to return.",
            "demoValue": 20,
            "minimum": 1,
            "maximum": 500,
            "optional": true,
            "default": 20
        }
      ]
        },
        "Order": {
            "description": "Place an order on a particular market",
            "target": "order",
            "uriTemplate": "/order",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "POST",
            "envelope": "JSON",
            "returns": {
                "$ref": "#.ApiTradeOrderResponseDTO"
            },
            "group": "Trades and Orders",
            "throttleScope": "trading",
            "parameters": [
        {
            "type": "integer",
            "name": "MarketId",
            "description": "A market's unique identifier",
            "demoValue": 71442,
            "minimum": 1000000,
            "maximum": 9999999
        },
        {
            "type": "string",
            "name": "Direction",
            "description": "Direction identifier for order/trade, values supported are buy or sell",
            "demoValue": "buy"
        },
        {
            "type": "number",
            "name": "Quantity",
            "description": "Size of the order/trade",
            "demoValue": 1.0
        },
        {
            "type": "number",
            "name": "BidPrice",
            "description": "Market prices are quoted as a pair (buy/sell or bid/offer), \n            the BidPrice is the lower of the two",
            "demoValue": 100.0
        },
        {
            "type": "number",
            "name": "OfferPrice",
            "description": "Market prices are quote as a pair (buy/sell or bid/offer),\n            the OfferPrice is the higher of the market price pair",
            "demoValue": 110.0
        },
        {
            "type": "string",
            "name": "AuditId",
            "description": "Unique identifier for a price tick",
            "demoValue": "5998CBE8-3594-4232-A57E-09EC3A4E7AA8"
        },
        {
            "type": "integer",
            "name": "TradingAccountId",
            "description": "TradingAccount associated with the trade/order request",
            "demoValue": 1
        },
        {
            "type": "string",
            "name": "Applicability",
            "description": "Identifier which relates to the expiry of the\n            order/trade, i.e. GoodTillDate (GTD), \n            GoodTillCancelled (GTC) or GoodForDay (GFD)",
            "demoValue": "GTC"
        },
        {
            "type": "string",
            "name": "ExpiryDateTimeUTC",
            "description": "The associated expiry DateTime for a \n            pair of GoodTillDate IfDone orders",
            "demoValue": "\\/Date(1290164280000)\\/"
        }
      ]
        },
        "CancelOrder": {
            "description": "Cancel an order",
            "target": "order",
            "uriTemplate": "/cancel",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "POST",
            "envelope": "JSON",
            "returns": {
                "$ref": "#.ApiTradeOrderResponseDTO"
            },
            "group": "Trades and Orders",
            "parameters": [
        {
            "type": "integer",
            "name": "OrderId",
            "description": "The order identifier"
        }
      ]
        },
        "ListOrders": {
            "description": "TODO",
            "target": "order",
            "uriTemplate": "/orders?TradingAccountId={tradingAccountId}&OpenOrders={openOrders}&AcceptedOrders={acceptedOrders}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.ListOrdersResponseDTO"
            },
            "group": "Trades and Orders",
            "parameters": [
        {
            "type": "integer",
            "name": "tradingAccountId",
            "description": "TODO"
        },
        {
            "type": "boolean",
            "name": "openOrders",
            "description": "TODO"
        },
        {
            "type": "boolean",
            "name": "acceptedOrders",
            "description": "TODO"
        }
      ]
        },
        "ListOpenPositions": {
            "description": "TODO",
            "target": "order",
            "uriTemplate": "/order/openpositions?TradingAccountId={tradingAccountId}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.ListOpenPositionsResponseDTO"
            },
            "group": "Trades and Orders",
            "parameters": [
        {
            "type": "integer",
            "name": "tradingAccountId",
            "description": "TODO"
        }
      ]
        },
        "ListActiveStopLimitOrders": {
            "description": "TODO",
            "target": "order",
            "uriTemplate": "/order/activestoplimitorders?TradingAccountId={tradingAccountId}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.ListActiveStopLimitOrderResponseDTO"
            },
            "group": "Trades and Orders",
            "parameters": [
        {
            "type": "integer",
            "name": "tradingAccountId",
            "description": "TODO"
        }
      ]
        },
        "ListTradeHistory": {
            "description": "TODO",
            "target": "order",
            "uriTemplate": "/order/tradehistory?TradingAccountId={tradingAccountId}&MaxResults={maxResults}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.ListTradeHistoryResponseDTO"
            },
            "group": "Trades and Orders",
            "parameters": [
        {
            "type": "integer",
            "name": "tradingAccountId",
            "description": "TODO"
        },
        {
            "type": "integer",
            "name": "maxResults",
            "description": "TODO"
        }
      ]
        },
        "ListStopLimitOrderHistory": {
            "description": "TODO",
            "target": "order",
            "uriTemplate": "/order/stoplimitorderhistory?TradingAccountId={tradingAccountId}&MaxResults={maxResults}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.ListStopLimitOrderHistoryResponseDTO"
            },
            "group": "Trades and Orders",
            "parameters": [
        {
            "type": "integer",
            "name": "tradingAccountId",
            "description": "TODO"
        },
        {
            "type": "integer",
            "name": "maxResults",
            "description": "TODO"
        }
      ]
        },
        "Trade": {
            "description": "Place a trade on a particular market",
            "target": "order",
            "uriTemplate": "/trade",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "POST",
            "envelope": "JSON",
            "returns": {
                "$ref": "#.ApiTradeOrderResponseDTO"
            },
            "group": "Trades and Orders",
            "throttleScope": "trading",
            "parameters": [
        {
            "type": "integer",
            "name": "MarketId",
            "description": "A market's unique identifier",
            "demoValue": 71442,
            "minimum": 1000000,
            "maximum": 9999999
        },
        {
            "type": "string",
            "name": "Direction",
            "description": "Direction identifier for order/trade, values supported are buy or sell",
            "demoValue": "buy"
        },
        {
            "type": "number",
            "name": "Quantity",
            "description": "Size of the order/trade",
            "demoValue": 1.0
        },
        {
            "type": "number",
            "name": "BidPrice",
            "description": "Market prices are quoted as a pair (buy/sell or bid/offer), \n            the BidPrice is the lower of the two",
            "demoValue": 100.0
        },
        {
            "type": "number",
            "name": "OfferPrice",
            "description": "Market prices are quote as a pair (buy/sell or bid/offer),\n            the OfferPrice is the higher of the market price pair",
            "demoValue": 110.0
        },
        {
            "type": "string",
            "name": "AuditId",
            "description": "Unique identifier for a price tick",
            "demoValue": "5998CBE8-3594-4232-A57E-09EC3A4E7AA8"
        },
        {
            "type": "integer",
            "name": "TradingAccountId",
            "description": "TradingAccount associated with the trade/order request",
            "demoValue": 1
        }
      ]
        },
        "GetChartingEnabled": {
            "description": "Whether a User is allowed to see Charting Data",
            "target": "useraccount",
            "uriTemplate": "/UserAccount/{id}/ChartingEnabled",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.Boolean"
            },
            "group": "AccountInformation",
            "throttleScope": "data",
            "parameters": [
        {
            "type": "string",
            "name": "id",
            "description": "Whether a User is allowed to see Charting Data"
        }
      ]
        },
        "GetTermsAndConditions": {
            "description": "What are the Users Terms and Conditions",
            "target": "useraccount",
            "uriTemplate": "/UserAccount/{clientaccount}/TermsAndConditions",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.String"
            },
            "group": "AccountInformation",
            "throttleScope": "data",
            "parameters": [
        {
            "type": "string",
            "name": "clientaccount",
            "description": "What are the Users Terms and Conditions"
        }
      ]
        },
        "GetClientAndTradingAccount": {
            "description": "Returns the Users ClientAccountId and a list of their TradingAccounts",
            "target": "useraccount",
            "uriTemplate": "/UserAccount/ClientAndTradingAccount",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.AccountInformationResponseDTO"
            },
            "group": "AccountInformation",
            "throttleScope": "data",
            "parameters": []
        },
        "GenerateException": {
            "description": "Simulates an error condition.",
            "target": "errors",
            "uriTemplate": "?errorCode={errorCode}",
            "contentType": "application/json",
            "responseContentType": "application/json",
            "transport": "GET",
            "envelope": "URL",
            "returns": {
                "$ref": "#.ErrorResponseDTO"
            },
            "group": "Exception Handling",
            "throttleScope": "data",
            "parameters": [
        {
            "type": "integer",
            "name": "errorCode",
            "description": "Simulates an error condition.",
            "demoValue": 4000
        }
      ]
        }
    }
}
