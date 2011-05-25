{
  "SMDVersion": "2.6",
  "version": "1",
  "id": "http://localhost:14420/smd?includeDemoValue=true",
  "target": "http://localhost:14420/",
  "schema": "http://localhost:14420/schema?includeDemoValue=true",
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
          "$ref": "#.LogOnRequestDTO",
          "name": "logOnRequest",
          "description": "Create a new session.  The is how you \"log on\" to the CIAPI."
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
      "description": "Get Market Information for the specified market. You must be authorised to view the market, or the query will fail.",
      "target": "market",
      "uriTemplate": "/{marketId}/information",
      "contentType": "application/json",
      "responseContentType": "application/json",
      "transport": "GET",
      "envelope": "URL",
      "returns": {
        "$ref": "#.GetMarketInformationResponseDTO"
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
    "ListMarketInformationSearch": {
      "description": "Get Market Information for markets that fit the query.",
      "target": "market",
      "uriTemplate": "/market/informationsearch?SearchByMarketCode={searchByMarketCode}&SearchByMarketName={searchByMarketName}&SpreadProductType={spreadProductType}&CfdProductType={cfdProductType}&BinaryProductType={binaryProductType}&Query={query}&MaxResults={maxResults}",
      "contentType": "application/json",
      "responseContentType": "application/json",
      "transport": "GET",
      "envelope": "URL",
      "returns": {
        "$ref": "#.ListMarketInformationSearchResponseDTO"
      },
      "group": "Market",
      "throttleScope": "data",
      "parameters": [
        {
          "type": "boolean",
          "name": "searchByMarketCode",
          "description": "Should the search be done by market code",
          "demoValue": true
        },
        {
          "type": "boolean",
          "name": "searchByMarketName",
          "description": "Should the search be done by market Name",
          "demoValue": true
        },
        {
          "type": "boolean",
          "name": "spreadProductType",
          "description": "Should the search include spread bet markets",
          "demoValue": true
        },
        {
          "type": "boolean",
          "name": "cfdProductType",
          "description": "Should the search include CFD markets",
          "demoValue": true
        },
        {
          "type": "boolean",
          "name": "binaryProductType",
          "description": "Should the search include binary markets",
          "demoValue": true
        },
        {
          "type": "string",
          "name": "query",
          "description": "The text to search for.  Matches part of market name / code from the start.",
          "demoValue": "UK 100"
        },
        {
          "type": "integer",
          "name": "maxResults",
          "description": "The maximum number of results to return",
          "demoValue": 50
        }
      ]
    },
    "ListMarketInformation": {
      "description": "Get Market Information for the specified list of markets. You must be authorised to view all the markets in the supplied list, or the query will fail.",
      "target": "market",
      "uriTemplate": "/market/information",
      "contentType": "application/json",
      "responseContentType": "application/json",
      "transport": "POST",
      "envelope": "JSON",
      "returns": {
        "$ref": "#.ListMarketInformationResponseDTO"
      },
      "group": "Market",
      "throttleScope": "data",
      "parameters": [
        {
          "type": "array",
          "items": {
            "$ref": "#.ListMarketInformationRequestDTO"
          },
          "name": "listMarketInformationRequestDTO",
          "description": "Get Market Information for the specified list of markets.  You must be authorised to view all the markets in the supplied list, or the query will fail."
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
          "$ref": "#.NewStopLimitOrderRequestDTO",
          "name": "order",
          "description": "The order request"
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
          "$ref": "#.CancelOrderRequestDTO",
          "name": "cancelOrder",
          "description": "The cancel order request"
        }
      ]
    },
    "ListOrders": {
      "description": "Not Implemented.",
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
          "description": "Not Implemented."
        },
        {
          "type": "boolean",
          "name": "openOrders",
          "description": "Not Implemented."
        },
        {
          "type": "boolean",
          "name": "acceptedOrders",
          "description": "Not Implemented."
        }
      ]
    },
    "ListOpenPositions": {
      "description": "Queries for a specified trading account's trades / open positions.",
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
          "description": "Queries for a specified trading account's trades / open positions."
        }
      ]
    },
    "ListActiveStopLimitOrders": {
      "description": "Queries for a specified trading account's active stop / limit orders.",
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
          "description": "Queries for a specified trading account's active stop / limit orders."
        }
      ]
    },
    "GetActiveStopLimitOrder": {
      "description": "Queries for a active stop limit order with a specified order id. It will return a null value if the order doesn't exist, or is not an active stop limit order.",
      "target": "order",
      "uriTemplate": "/{orderId}/activestoplimitorder",
      "contentType": "application/json",
      "responseContentType": "application/json",
      "transport": "GET",
      "envelope": "URL",
      "returns": {
        "$ref": "#.GetActiveStopLimitOrderResponseDTO"
      },
      "group": "Trades and Orders",
      "parameters": [
        {
          "type": "string",
          "name": "orderId",
          "description": "Queries for a active stop limit order with a specified order id.  It will return a null value if the order doesn't exist, or is not an active stop limit order."
        }
      ]
    },
    "GetOpenPosition": {
      "description": "Queries for a trade / open position with a specified order id. It will return a null value if the order doesn't exist, or is not a trade / open position.",
      "target": "order",
      "uriTemplate": "/{orderId}/openposition",
      "contentType": "application/json",
      "responseContentType": "application/json",
      "transport": "GET",
      "envelope": "URL",
      "returns": {
        "$ref": "#.GetOpenPositionResponseDTO"
      },
      "group": "Trades and Orders",
      "parameters": [
        {
          "type": "string",
          "name": "orderId",
          "description": "Queries for a trade / open position with a specified order id.  It will return a null value if the order doesn't exist, or is not a trade / open position."
        }
      ]
    },
    "ListTradeHistory": {
      "description": "Queries for a specified trading account's trade history.",
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
          "description": "Queries for a specified trading account's trade history."
        },
        {
          "type": "integer",
          "name": "maxResults",
          "description": "Queries for a specified trading account's trade history."
        }
      ]
    },
    "ListStopLimitOrderHistory": {
      "description": "Queries for a specified trading account's stop / limit order history.",
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
          "description": "Queries for a specified trading account's stop / limit order history."
        },
        {
          "type": "integer",
          "name": "maxResults",
          "description": "Queries for a specified trading account's stop / limit order history."
        }
      ]
    },
    "GetOrder": {
      "description": "Queries for an order by a specific order id. The current implementation only returns active orders (i.e. those with a status of 1 - Pending, 2 - Accepted, 3 - Open, 6 - Suspended, 8 - Yellow Card, 11 - Triggered).",
      "target": "order",
      "uriTemplate": "/{orderId}",
      "contentType": "application/json",
      "responseContentType": "application/json",
      "transport": "GET",
      "envelope": "URL",
      "returns": {
        "$ref": "#.GetOrderResponseDTO"
      },
      "group": "Trades and Orders",
      "parameters": [
        {
          "type": "string",
          "name": "orderId",
          "description": "Queries for an order by a specific order id.  The current implementation only returns active orders (i.e. those with a status of 1 - Pending, 2 - Accepted, 3 - Open, 6 - Suspended, 8 - Yellow Card, 11 - Triggered)."
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
          "$ref": "#.NewTradeOrderRequestDTO",
          "name": "trade",
          "description": "Place a trade on a particular market"
        }
      ]
    },
    "Update": {
      "description": "Update a trade",
      "target": "order",
      "uriTemplate": "/update",
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
          "$ref": "#.UpdateTradeOrderRequestDTO",
          "name": "update",
          "description": "Update a trade"
        }
      ]
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
