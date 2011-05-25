{
  "QuoteDTO": {
    "id": "QuoteDTO",
    "type": "object",
    "description": "A quote for a specific order request",
    "properties": {
      "QuoteId": {
        "type": "integer",
        "description": "The uniqueId of the Quote",
        "demoValue": 54198759874
      },
      "OrderId": {
        "type": "integer",
        "description": "The Order the Quote is related to",
        "demoValue": 8458418478
      },
      "MarketId": {
        "type": "integer",
        "description": "The Market the Quote is related to",
        "demoValue": 425748
      },
      "BidPrice": {
        "type": "number",
        "description": "The Price of the original Order request for a Buy",
        "demoValue": 1.12345,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "BidAdjust": {
        "type": "number",
        "description": "The amount the bid price will be adjusted to become an order when the customer is buying (BidPrice + BidAdjust = BuyPrice)",
        "demoValue": 1.12345,
        "minimum": -999999999.0,
        "maximum": 999999999.0
      },
      "OfferPrice": {
        "type": "number",
        "description": "The Price of the original Order request for a Sell",
        "demoValue": 1.12345,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "OfferAdjust": {
        "type": "number",
        "description": "The amount the offer price will be adjusted to become an order when the customer is selling (OfferPrice + OfferAdjust = OfferPrice)",
        "demoValue": 1.12345,
        "minimum": -999999999.0,
        "maximum": 999999999.0
      },
      "Quantity": {
        "type": "number",
        "description": "The Quantity is the number of units for the trade i.e CFD Quantity = Number of CFD's to Buy or Sell , FX Quantity = Number of Currency points TODO Clarify",
        "demoValue": 1.1
      },
      "CurrencyId": {
        "type": "integer",
        "description": "The system internal Id for the ISO Currency the equivalent ISO Code can be found using the API Call TODO Fill when the API call is available",
        "demoValue": 1
      },
      "StatusId": {
        "type": "integer",
        "description": "The Status of the Quote. The list of different Status values can be found using the API call TODO Fill when call avaliable",
        "demoValue": 1
      },
      "TypeId": {
        "type": "integer",
        "description": "The reason for the Quote i.e you asked for a quote , a order was requested over a size limit",
        "demoValue": 1
      },
      "RequestDateTime": {
        "type": "string",
        "description": "The timestamp the quote was requested. Always expressed in UTC",
        "demoValue": "/Date(1289231327280)/"
      }
    }
  },
  "PriceBarDTO": {
    "id": "PriceBarDTO",
    "type": "object",
    "description": "The details of a specific price bar, useful for plotting candlestick charts",
    "properties": {
      "BarDate": {
        "type": "string",
        "description": "The date of the start of the price bar interval",
        "demoValue": "/Date(1287136540715)/",
        "format": "wcf-date"
      },
      "Open": {
        "type": "number",
        "description": "The price at the open of the price bar interval",
        "demoValue": 1.5
      },
      "High": {
        "type": "number",
        "description": "The highest price occuring during the interval of the price bar",
        "demoValue": 2.343
      },
      "Low": {
        "type": "number",
        "description": "The lowest price occuring during the interval of the price bar",
        "demoValue": 1.3423
      },
      "Close": {
        "type": "number",
        "description": "The price at the end of the price bar interval",
        "demoValue": 2.42
      }
    }
  },
  "GatewayOrderDTO": {
    "id": "GatewayOrderDTO",
    "type": "object",
    "description": "Represents an order",
    "properties": {}
  },
  "ApiOpenPositionDTO": {
    "id": "ApiOpenPositionDTO",
    "type": "object",
    "description": "A Trade, or order that is currently open.",
    "properties": {
      "OrderId": {
        "type": "integer",
        "description": "The order's unique identifier."
      },
      "MarketId": {
        "type": "integer",
        "description": "The markets unique identifier."
      },
      "MarketName": {
        "type": "string",
        "description": "The market's name."
      },
      "Direction": {
        "type": "string",
        "description": "The direction, buy or sell."
      },
      "Quantity": {
        "type": "number",
        "description": "The quantity of the order."
      },
      "Price": {
        "type": "number",
        "description": "The price / rate that the trade was opened at."
      },
      "TradingAccountId": {
        "type": "integer",
        "description": "The trading account that the order is on."
      },
      "Currency": {
        "type": "string",
        "description": "The trade currency."
      },
      "Status": {
        "type": "integer",
        "description": "The order status."
      },
      "StopOrder": {
        "$ref": "#.ApiBasicStopLimitOrderDTO",
        "description": "The stop order attached to this order."
      },
      "LimitOrder": {
        "$ref": "#.ApiBasicStopLimitOrderDTO",
        "description": "The limit order attached to this order."
      },
      "LastChangedDateTimeUTC": {
        "type": "string",
        "description": "The last time that the order changed. Note - Does not include things such as the current market price."
      }
    }
  },
  "ApiBasicStopLimitOrderDTO": {
    "id": "ApiBasicStopLimitOrderDTO",
    "type": "object",
    "description": "A stop or limit order with a limited number of data fields.",
    "properties": {
      "OrderId": {
        "type": "integer",
        "description": "The order's unique identifier."
      },
      "TriggerPrice": {
        "type": "number",
        "description": "The order's trigger price."
      },
      "Quantity": {
        "type": "number",
        "description": "The quantity of the product."
      }
    }
  },
  "OrderDTO": {
    "id": "OrderDTO",
    "type": "object",
    "description": "An order for a specific Trading Account",
    "properties": {
      "OrderId": {
        "type": "integer",
        "description": "???",
        "demoValue": 100
      },
      "MarketId": {
        "type": "integer",
        "description": "???",
        "demoValue": 100
      },
      "ClientAccountId": {
        "type": "integer",
        "description": "???",
        "demoValue": 100
      },
      "TradingAccountId": {
        "type": "integer",
        "description": "???",
        "demoValue": 100
      },
      "CurrencyId": {
        "type": "integer",
        "description": "???",
        "demoValue": 100,
        "minimum": 0,
        "maximum": 999999999
      },
      "CurrencyISO": {
        "type": "string",
        "description": "???",
        "demoValue": "GBP"
      },
      "Direction": {
        "type": "integer",
        "description": "???",
        "demoValue": 1
      },
      "AutoRollover": {
        "type": "boolean",
        "description": "???",
        "demoValue": true
      },
      "ExecutionPrice": {
        "type": "number",
        "description": "???",
        "demoValue": 96.1575,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "LastChangedTime": {
        "type": "string",
        "description": "The date of the Order. Always expressed in UTC",
        "demoValue": "/Date(1289231327280)/"
      },
      "OpenPrice": {
        "type": "number",
        "description": "???",
        "demoValue": 96.1575,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "OriginalLastChangedDateTime": {
        "type": "string",
        "description": "The date of the Order. Always expressed in UTC",
        "demoValue": "/Date(1289231327280)/"
      },
      "OriginalQuantity": {
        "type": "number",
        "description": "???",
        "demoValue": 96.1575,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "Quantity": {
        "type": "number",
        "description": "???",
        "demoValue": 96.1575,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "Type": {
        "type": "string",
        "description": "???",
        "demoValue": "TODO"
      },
      "Status": {
        "type": "string",
        "description": "???",
        "demoValue": "96.1575"
      },
      "ReasonId": {
        "type": "integer",
        "description": "???",
        "demoValue": 1
      }
    }
  },
  "ApiStopLimitOrderHistoryDTO": {
    "id": "ApiStopLimitOrderHistoryDTO",
    "type": "object",
    "description": "A stop or limit order from a historical perspective.",
    "properties": {
      "OrderId": {
        "type": "integer",
        "description": "The order's unique identifier."
      },
      "MarketId": {
        "type": "integer",
        "description": "The markets unique identifier."
      },
      "MarketName": {
        "type": "string",
        "description": "The market's name."
      },
      "Direction": {
        "type": "string",
        "description": "The direction, buy or sell."
      },
      "OriginalQuantity": {
        "type": "number",
        "description": "The quantity of the order when it became a trade / was cancelled etc."
      },
      "Price": {
        "type": "string",
        "description": "The price / rate that the order was filled at."
      },
      "TriggerPrice": {
        "type": "number",
        "description": "The price / rate that the the order was set to trigger at."
      },
      "TradingAccountId": {
        "type": "integer",
        "description": "The trading account that the order is on."
      },
      "TypeId": {
        "type": "integer",
        "description": "The type of the order stop, limit or trade."
      },
      "OrderApplicabilityId": {
        "type": "integer",
        "description": "When the order applies until. i.e. good till cancelled (GTC) good for day (GFD) or good till time (GTT)."
      },
      "Currency": {
        "type": "string",
        "description": "The trade currency."
      },
      "StatusId": {
        "type": "integer",
        "description": "the order status."
      },
      "LastChangedDateTimeUtc": {
        "type": "string",
        "description": "The last time that the order changed. Note - Does not include things such as the current market price."
      }
    }
  },
  "MarketInformationDTO": {
    "id": "MarketInformationDTO",
    "type": "object",
    "description": "Contains details of a specific news story",
    "properties": {
      "MarketId": {
        "type": "integer",
        "description": "TODO"
      },
      "Name": {
        "type": "string",
        "description": "The market name",
        "demoValue": "Vodafone CFD",
        "minLength": 1,
        "maxLength": 120
      },
      "MarginFactor": {
        "type": "string",
        "description": "TODO"
      },
      "MinDistance": {
        "type": "string",
        "description": "TODO"
      },
      "WebMinSize": {
        "type": "string",
        "description": "TODO"
      },
      "MaxSize": {
        "type": "string",
        "description": "TODO"
      },
      "Market24H": {
        "type": "boolean",
        "description": "TODO"
      },
      "PriceDecimalPlaces": {
        "type": "string",
        "description": "TODO"
      },
      "DefaultQuoteLength": {
        "type": "string",
        "description": "TODO"
      },
      "TradeOnWeb": {
        "type": "boolean",
        "description": "TODO"
      },
      "LimitUp": {
        "type": "boolean",
        "description": "TODO"
      },
      "LimitDown": {
        "type": "boolean",
        "description": "TODO"
      },
      "LongPositionOnly": {
        "type": "boolean",
        "description": "TODO"
      },
      "CloseOnly": {
        "type": "boolean",
        "description": "TODO"
      },
      "MarketEod": {
        "type": "array",
        "items": {
          "$ref": "#.MarketEodDTO"
        },
        "description": "TODO"
      }
    }
  },
  "ApiLookupDTO": {
    "id": "ApiLookupDTO",
    "type": "object",
    "description": "Generic look up data",
    "properties": {}
  },
  "TradingAccountDTO": {
    "id": "TradingAccountDTO",
    "type": "object",
    "description": "Information about a TradingAccount",
    "properties": {
      "TradingAccountId": {
        "type": "integer",
        "description": "TODO"
      },
      "TradingAccountCode": {
        "type": "string",
        "description": "TODO"
      },
      "TradingAccountStatus": {
        "type": "string",
        "description": "TODO"
      },
      "TradingAccountType": {
        "type": "string",
        "description": "TODO"
      }
    }
  },
  "GatewayIfDoneDTO": {
    "id": "GatewayIfDoneDTO",
    "type": "object",
    "description": "An IfDone order represents an order which is placed when the corresponding order is filled, e.g attaching a stop/limit to a trade or order",
    "properties": {
      "Stop": {
        "$ref": "#.GatewayStopLimitOrderDTO",
        "description": "The price at which the stop order will be filled"
      },
      "Limit": {
        "$ref": "#.GatewayStopLimitOrderDTO",
        "description": "The price at which the limit order will be filled"
      }
    }
  },
  "ApiActiveStopLimitOrderDTO": {
    "id": "ApiActiveStopLimitOrderDTO",
    "type": "object",
    "description": "A stop or limit order that is currently active.",
    "properties": {
      "OrderId": {
        "type": "integer",
        "description": "The order's unique identifier."
      },
      "ParentOrderId": {
        "type": "string",
        "description": "The order's parent OrderId."
      },
      "MarketId": {
        "type": "integer",
        "description": "The markets unique identifier."
      },
      "MarketName": {
        "type": "string",
        "description": "The market's name."
      },
      "Direction": {
        "type": "string",
        "description": "The direction, buy or sell."
      },
      "Quantity": {
        "type": "number",
        "description": "The quantity of the product."
      },
      "TriggerPrice": {
        "type": "number",
        "description": "The marked to market price at which the order will trigger at."
      },
      "TradingAccountId": {
        "type": "number",
        "description": "The trading account that the order is on."
      },
      "Type": {
        "type": "integer",
        "description": "The type of order, i.e. stop or limit."
      },
      "Applicability": {
        "type": "integer",
        "description": "When the order applies until. i.e. good till cancelled (GTC) good for day (GFD) or good till time (GTT)."
      },
      "ExpiryDateTimeUTC": {
        "type": "string",
        "description": "The associated expiry DateTime.",
        "demoValue": "\\/Date(1290164280000)\\/"
      },
      "Currency": {
        "type": "string",
        "description": "The trade currency."
      },
      "Status": {
        "type": "integer",
        "description": "The order status."
      },
      "StopOrder": {
        "$ref": "#.ApiBasicStopLimitOrderDTO",
        "description": "The if done stop order."
      },
      "LimitOrder": {
        "$ref": "#.ApiBasicStopLimitOrderDTO",
        "description": "The if done limit order"
      },
      "OcoOrder": {
        "$ref": "#.ApiBasicStopLimitOrderDTO",
        "description": "The order on the other side of a one Cancels the other relationship."
      },
      "LastChangedDateTimeUTC": {
        "type": "string",
        "description": "The last time that the order changed. Note - Does not include things such as the current market price."
      }
    }
  },
  "PriceDTO": {
    "id": "PriceDTO",
    "type": "object",
    "description": "A Price for a specific Market",
    "properties": {
      "MarketId": {
        "type": "integer",
        "description": "The Market that the Price is related to",
        "demoValue": 1000,
        "minimum": 1,
        "maximum": 9999999
      },
      "TickDate": {
        "type": "string",
        "description": "The date of the Price. Always expressed in UTC",
        "demoValue": "/Date(1289231327280)/"
      },
      "Bid": {
        "type": "number",
        "description": "The current Bid price (price at which the customer can sell)",
        "demoValue": 96.1575,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "Offer": {
        "type": "number",
        "description": "The current Offer price (price at which the customer can buy)",
        "demoValue": 96.1575,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "Price": {
        "type": "number",
        "description": "The current mid price",
        "demoValue": 96.1575,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "High": {
        "type": "number",
        "description": "The highest price reached for the day",
        "demoValue": 96.1575,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "Low": {
        "type": "number",
        "description": "The lowest price reached for the day",
        "demoValue": 96.1575,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "Change": {
        "type": "number",
        "description": "The change since the last price (always positive. See Direction for direction)",
        "demoValue": 96.1575,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "Direction": {
        "type": "integer",
        "description": "The direction of movement since the last price. 1 == up, 0 == down",
        "demoValue": 1,
        "minimum": 0,
        "maximum": 1
      },
      "AuditId": {
        "type": "string",
        "description": "A unique id for this price. Treat as a unique, but random string",
        "demoValue": "o892nkl8hopin"
      }
    }
  },
  "GatewayStopLimitOrderDTO": {
    "id": "GatewayStopLimitOrderDTO",
    "type": "object",
    "description": "Represents a stop/limit order",
    "extends": {
      "$ref": "#.GatewayOrderDTO"
    },
    "properties": {
      "ExpiryDateTimeUTC": {
        "type": "string",
        "description": "The associated expiry DateTime for a pair of GoodTillDate IfDone orders",
        "demoValue": "\\/Date(1290164280000)\\/"
      },
      "Applicability": {
        "type": "string",
        "description": "Identifier which relates to the expiry of the order/trade, i.e. GoodTillDate (GTD), GoodTillCancelled (GTC) or GoodForDay (GFD)",
        "demoValue": "GTC"
      }
    }
  },
  "MarketDTO": {
    "id": "MarketDTO",
    "type": "object",
    "description": "Information about a Market",
    "properties": {
      "MarketId": {
        "type": "integer",
        "description": "A market's unique identifier",
        "demoValue": 254527845,
        "minimum": 1000000,
        "maximum": 9999999
      },
      "Name": {
        "type": "string",
        "description": "The market name",
        "demoValue": "Vodaphone CFD",
        "minLength": 1,
        "maxLength": 120
      }
    }
  },
  "NewsDTO": {
    "id": "NewsDTO",
    "type": "object",
    "description": "A news headline",
    "properties": {
      "StoryId": {
        "type": "integer",
        "description": "The unique identifier for a news story",
        "demoValue": 12654,
        "minimum": 1,
        "maximum": 2147483647
      },
      "Headline": {
        "type": "string",
        "description": "The News story headline",
        "demoValue": "Barron's(8/29) Speaking Of Dividends: The Big Cheese: Kraft Foods Slices Costs And Serves A Payout Hike"
      },
      "PublishDate": {
        "type": "string",
        "description": "The date on which the news story was published. Always in UTC",
        "demoValue": "/Date(1289231327280)/"
      }
    }
  },
  "MarketEodDTO": {
    "id": "MarketEodDTO",
    "type": "object",
    "description": "FIXME: DESCRIPTION",
    "properties": {
      "MarketEodUnit": {
        "type": "string",
        "description": "FIXME: DESCRIPTION",
        "demoValue": "demo value"
      },
      "MarketEodAmount": {
        "type": "string",
        "description": "FIXME: DESCRIPTION",
        "demoValue": "0"
      }
    }
  },
  "ClientAccountMarginDTO": {
    "id": "ClientAccountMarginDTO",
    "type": "object",
    "description": "The current margin for a specific client account",
    "properties": {
      "Cash": {
        "type": "number",
        "description": "???",
        "demoValue": 100.0,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "Margin": {
        "type": "number",
        "description": "???",
        "demoValue": 100.0,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "MarginIndicator": {
        "type": "number",
        "description": "???",
        "demoValue": 100.0,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "NetEquity": {
        "type": "number",
        "description": "???",
        "demoValue": 100.0,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "OpenTradeEquity": {
        "type": "number",
        "description": "???",
        "demoValue": 100.0,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "TradeableFunds": {
        "type": "number",
        "description": "???",
        "demoValue": 100.0,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "PendingFunds": {
        "type": "number",
        "description": "???",
        "demoValue": 100.0,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "TradingResource": {
        "type": "number",
        "description": "???",
        "demoValue": 100.0,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "TotalMarginRequirement": {
        "type": "number",
        "description": "???",
        "demoValue": 100.0,
        "minimum": 0.0,
        "maximum": 999999999.0
      },
      "CurrencyId": {
        "type": "integer",
        "description": "???",
        "demoValue": 100
      },
      "CurrencyISO": {
        "type": "string",
        "description": "???",
        "demoValue": "GBP"
      }
    }
  },
  "PriceTickDTO": {
    "id": "PriceTickDTO",
    "type": "object",
    "description": "The mid price at a particular point in time.",
    "properties": {
      "TickDate": {
        "type": "string",
        "description": "The datetime at which a price tick occured. Accurate to the millisecond",
        "demoValue": "/Date(1287136540715)/",
        "format": "wcf-date"
      },
      "Price": {
        "type": "number",
        "description": "The mid price",
        "demoValue": 1.5457,
        "minimum": 0.0
      }
    }
  },
  "ApiTradeHistoryDTO": {
    "id": "ApiTradeHistoryDTO",
    "type": "object",
    "description": "A Trade from a historical perspective.",
    "properties": {
      "OrderId": {
        "type": "integer",
        "description": "The order id."
      },
      "MarketId": {
        "type": "integer",
        "description": "The market id."
      },
      "MarketName": {
        "type": "string",
        "description": "The name of the market."
      },
      "Direction": {
        "type": "string",
        "description": "The direction of the trade."
      },
      "OriginalQuantity": {
        "type": "number",
        "description": "The original quantity of the trade, before part closures."
      },
      "Price": {
        "type": "number",
        "description": "The open price of the trade."
      },
      "TradingAccountId": {
        "type": "integer",
        "description": "The trading account that the order is on."
      },
      "Currency": {
        "type": "string",
        "description": "The trade currency."
      },
      "LastChangedDateTimeUtc": {
        "type": "string",
        "description": "The last time that the order changed. Note - Does not include things such as the current market price."
      }
    }
  },
  "NewsDetailDTO": {
    "id": "NewsDetailDTO",
    "type": "object",
    "description": "Contains details of a specific news story",
    "extends": {
      "$ref": "#.NewsDTO"
    },
    "properties": {
      "Story": {
        "type": "string",
        "description": "The detail of the story. This can contain HTML characters.",
        "demoValue": "<pre>    (Expect lots of HTML here)     By Shirley A. Lazo </pre><p>    (END) Dow Jones Newswires</p><p>   August 27, 2005 00:01 ET (04:01 GMT)</p>",
        "minLength": 0,
        "maxLength": 2147483647
      }
    }
  },
  "ListCfdMarketsResponseDTO": {
    "id": "ListCfdMarketsResponseDTO",
    "type": "object",
    "description": "Contains the result of a ListCfdMarkets query",
    "properties": {
      "Markets": {
        "type": "array",
        "items": {
          "$ref": "#.MarketDTO"
        },
        "description": "A list of CFD markets"
      }
    }
  },
  "ApiQuoteResponseDTO": {
    "id": "ApiQuoteResponseDTO",
    "type": "object",
    "description": "TODO",
    "properties": {
      "QuoteId": {
        "type": "integer",
        "description": "TODO"
      },
      "Status": {
        "type": "integer",
        "description": "TODO"
      },
      "StatusReason": {
        "type": "integer",
        "description": "TODO"
      }
    }
  },
  "ApiOrderResponseDTO": {
    "id": "ApiOrderResponseDTO",
    "type": "object",
    "description": "TODO",
    "properties": {
      "OrderId": {
        "type": "integer",
        "description": "TODO"
      },
      "StatusReason": {
        "type": "integer",
        "description": "TODO"
      },
      "Status": {
        "type": "integer",
        "description": "TODO"
      },
      "Price": {
        "type": "number",
        "description": "TODO"
      },
      "CommissionCharge": {
        "type": "number",
        "description": "TODO"
      },
      "IfDone": {
        "type": "array",
        "items": {
          "$ref": "#.ApiIfDoneResponseDTO"
        },
        "description": "TODO"
      },
      "GuaranteedPremium": {
        "type": "number",
        "description": "TODO"
      },
      "OCO": {
        "$ref": "#.ApiOrderResponseDTO",
        "description": "TODO"
      }
    }
  },
  "GetPriceBarResponseDTO": {
    "id": "GetPriceBarResponseDTO",
    "type": "object",
    "description": "The response from a GET price bar history request. Contains both an array of finalized price bars, and a partial (not finalized) bar for the current period",
    "properties": {
      "PriceBars": {
        "type": "array",
        "items": {
          "$ref": "#.PriceBarDTO"
        },
        "description": "An array of finalized price bars, sorted in ascending order based on PriceBar.BarDate"
      }
    }
  },
  "ListStopLimitOrderHistoryResponseDTO": {
    "id": "ListStopLimitOrderHistoryResponseDTO",
    "type": "object",
    "description": "Contains the result of a ListStopLimitOrderHistory query",
    "properties": {
      "StopLimitOrderHistory": {
        "type": "array",
        "items": {
          "$ref": "#.ApiStopLimitOrderHistoryDTO"
        },
        "description": "A list of historical stop / limit orders."
      }
    }
  },
  "ListOrdersResponseDTO": {
    "id": "ListOrdersResponseDTO",
    "type": "object",
    "description": "TODO",
    "properties": {}
  },
  "NewTradeOrderRequestDTO": {
    "id": "NewTradeOrderRequestDTO",
    "type": "object",
    "description": "A request for a trade order",
    "properties": {
      "MarketId": {
        "type": "integer",
        "description": "A market's unique identifier",
        "demoValue": 71442,
        "minimum": 1000000,
        "maximum": 9999999
      },
      "Direction": {
        "type": "string",
        "description": "Direction identifier for order/trade, values supported are buy or sell",
        "demoValue": "buy"
      },
      "Quantity": {
        "type": "number",
        "description": "Size of the order/trade",
        "demoValue": 1.0
      },
      "BidPrice": {
        "type": "number",
        "description": "Market prices are quoted as a pair (buy/sell or bid/offer), the BidPrice is the lower of the two",
        "demoValue": 100.0
      },
      "OfferPrice": {
        "type": "number",
        "description": "Market prices are quote as a pair (buy/sell or bid/offer), the OfferPrice is the higher of the market price pair",
        "demoValue": 110.0
      },
      "AuditId": {
        "type": "string",
        "description": "Unique identifier for a price tick",
        "demoValue": "5998CBE8-3594-4232-A57E-09EC3A4E7AA8"
      },
      "TradingAccountId": {
        "type": "integer",
        "description": "TradingAccount associated with the trade/order request",
        "demoValue": 1
      },
      "IfDone": {
        "type": "array",
        "items": {
          "$ref": "#.GatewayIfDoneDTO"
        },
        "description": "List of IfDone Orders which will be filled when the initial trade/order is triggered"
      },
      "Close": {
        "type": "array",
        "items": {
          "type": "integer"
        },
        "description": "List of existing order id's that require part or full closure"
      }
    }
  },
  "ListMarketInformationRequestDTO": {
    "id": "ListMarketInformationRequestDTO",
    "type": "object",
    "description": "Get market information for a list of markets.",
    "properties": {}
  },
  "ListMarketInformationResponseDTO": {
    "id": "ListMarketInformationResponseDTO",
    "type": "object",
    "description": "Response from am market information request.",
    "properties": {
      "MarketInformation": {
        "type": "array",
        "items": {
          "$ref": "#.MarketInformationDTO"
        },
        "description": "The requested list of market information."
      }
    }
  },
  "NewStopLimitOrderRequestDTO": {
    "id": "NewStopLimitOrderRequestDTO",
    "type": "object",
    "description": "A request for a stop/limit order",
    "properties": {
      "OrderId": {
        "type": "integer",
        "description": "Order identifier of the order to update"
      },
      "MarketId": {
        "type": "integer",
        "description": "A market's unique identifier",
        "demoValue": 71442,
        "minimum": 1000000,
        "maximum": 9999999
      },
      "Currency": {
        "type": "string",
        "description": "Currency to place order in"
      },
      "AutoRollover": {
        "type": "boolean",
        "description": "Flag to indicate whether the trade will automatically roll into the next market when the current market expires"
      },
      "Direction": {
        "type": "string",
        "description": "Direction identifier for order/trade, values supported are buy or sell",
        "demoValue": "buy"
      },
      "Quantity": {
        "type": "number",
        "description": "Size of the order/trade",
        "demoValue": 1.0
      },
      "BidPrice": {
        "type": "number",
        "description": "Market prices are quoted as a pair (buy/sell or bid/offer), the BidPrice is the lower of the two",
        "demoValue": 100.0
      },
      "OfferPrice": {
        "type": "number",
        "description": "Market prices are quote as a pair (buy/sell or bid/offer), the OfferPrice is the higher of the market price pair",
        "demoValue": 110.0
      },
      "AuditId": {
        "type": "string",
        "description": "Unique identifier for a price tick",
        "demoValue": "5998CBE8-3594-4232-A57E-09EC3A4E7AA8"
      },
      "TradingAccountId": {
        "type": "integer",
        "description": "TradingAccount associated with the trade/order request",
        "demoValue": 1
      },
      "IfDone": {
        "type": "array",
        "items": {
          "$ref": "#.GatewayIfDoneDTO"
        },
        "description": "List of IfDone Orders which will be filled when the initial trade/order is triggered"
      },
      "OcoOrder": {
        "$ref": "#.NewStopLimitOrderRequestDTO",
        "description": "Corresponding OcoOrder (One Cancels the Other)"
      },
      "Applicability": {
        "type": "string",
        "description": "Identifier which relates to the expiry of the order/trade, i.e. GoodTillDate (GTD), GoodTillCancelled (GTC) or GoodForDay (GFD)",
        "demoValue": "GTC"
      },
      "ExpiryDateTimeUTC": {
        "type": "string",
        "description": "The associated expiry DateTime for a pair of GoodTillDate IfDone orders",
        "demoValue": "\\/Date(1290164280000)\\/"
      },
      "Guaranteed": {
        "type": "boolean",
        "description": "Flag to determine whether an order is guaranteed to trigger and fill at the associated trigger price"
      },
      "TriggerPrice": {
        "type": "number",
        "description": "Price at which the order is intended to be triggered"
      }
    }
  },
  "UpdateStopLimitOrderRequestDTO": {
    "id": "UpdateStopLimitOrderRequestDTO",
    "type": "object",
    "description": "A request for updating a stop/limit order",
    "extends": {
      "$ref": "#.NewStopLimitOrderRequestDTO"
    },
    "properties": {}
  },
  "GetNewsDetailResponseDTO": {
    "id": "GetNewsDetailResponseDTO",
    "type": "object",
    "description": "JSON returned from News Detail GET request",
    "properties": {
      "NewsDetail": {
        "$ref": "#.NewsDetailDTO",
        "description": "The details of the news item"
      }
    }
  },
  "ListNewsHeadlinesResponseDTO": {
    "id": "ListNewsHeadlinesResponseDTO",
    "type": "object",
    "description": "The response from a GET request for News headlines",
    "properties": {
      "Headlines": {
        "type": "array",
        "items": {
          "$ref": "#.NewsDTO"
        },
        "description": "A list of News headlines"
      }
    }
  },
  "GetOpenPositionResponseDTO": {
    "id": "GetOpenPositionResponseDTO",
    "type": "object",
    "description": "Response containing the open position.",
    "properties": {
      "OpenPosition": {
        "$ref": "#.ApiOpenPositionDTO",
        "description": "The open position. If it is null then the open position does not exist."
      }
    }
  },
  "CreateSessionResponseDTO": {
    "id": "CreateSessionResponseDTO",
    "type": "object",
    "description": "Response to a CreateSessionRequest",
    "properties": {
      "Session": {
        "type": "string",
        "description": "Your session token (treat as a random string) <BR /> Session tokens are valid for a set period from the time of their creation. <BR /> The period is subject to change, and may vary depending on who you logon as.",
        "demoValue": "D2FF3E4D-01EA-4741-86F0-437C919B5559",
        "minLength": 36,
        "maxLength": 100
      }
    }
  },
  "SessionDeletionResponseDTO": {
    "id": "SessionDeletionResponseDTO",
    "type": "object",
    "description": "",
    "properties": {
      "LoggedOut": {
        "type": "boolean",
        "description": "LogOut status",
        "demoValue": true
      }
    }
  },
  "ListActiveStopLimitOrderResponseDTO": {
    "id": "ListActiveStopLimitOrderResponseDTO",
    "type": "object",
    "description": "Contains the result of a ListActiveStopLimitOrder query",
    "properties": {
      "ActiveStopLimitOrders": {
        "type": "array",
        "items": {
          "$ref": "#.ApiActiveStopLimitOrderDTO"
        },
        "description": "The requested list of active stop / limit orders."
      }
    }
  },
  "G2SessionValidationResponseDTO": {
    "id": "G2SessionValidationResponseDTO",
    "type": "object",
    "description": "",
    "properties": {
      "ClientAccountIds": {
        "type": "array",
        "items": {
          "type": "integer"
        },
        "description": "ClientAccountIds that this session is authorized to work with",
        "demoValue": [
          1,
          2,
          3,
          4
        ]
      },
      "TradingAccountIds": {
        "type": "array",
        "items": {
          "type": "integer"
        },
        "description": "TradingAccountIds that this session is authorized to work with",
        "demoValue": [
          1,
          2,
          3,
          4
        ]
      },
      "IsValid": {
        "type": "boolean",
        "description": "Whether this session token is still valid",
        "demoValue": true
      }
    }
  },
  "ApiTradeOrderResponseDTO": {
    "id": "ApiTradeOrderResponseDTO",
    "type": "object",
    "description": "The response returned from the underlying trading system",
    "properties": {
      "Status": {
        "type": "integer",
        "description": "The status of the order (Pending, Accepted, Open, etc)",
        "demoValue": 1
      },
      "StatusReason": {
        "type": "integer",
        "description": "The id corresponding to a more descriptive reason for the order status",
        "demoValue": 1
      },
      "OrderId": {
        "type": "integer",
        "description": "The unique identifier associated to the order returned from the underlying trading system",
        "demoValue": 1
      }
    }
  },
  "ApiIfDoneResponseDTO": {
    "id": "ApiIfDoneResponseDTO",
    "type": "object",
    "description": "TODO",
    "properties": {
      "Stop": {
        "$ref": "#.ApiOrderResponseDTO",
        "description": "TODO"
      },
      "Limit": {
        "$ref": "#.ApiOrderResponseDTO",
        "description": "TODO"
      }
    }
  },
  "ErrorCode": {
    "type": "integer",
    "demoValue": 403,
    "description": "This is a description of the ErrorCode enum",
    "enum": [
      403,
      500,
      4000,
      4001,
      4002,
      4003,
      4004,
      4010,
      4011,
      5001
    ],
    "options": [
      {
        "value": 403,
        "label": "Forbidden",
        "description": "This is a description of Forbidden"
      },
      {
        "value": 500,
        "label": "InternalServerError",
        "description": "This is a description of InternalServerError"
      },
      {
        "value": 4000,
        "label": "InvalidParameterType",
        "description": "This is a description of InvalidParameterType"
      },
      {
        "value": 4001,
        "label": "ParameterMissing",
        "description": "This is a description of ParameterMissing"
      },
      {
        "value": 4002,
        "label": "InvalidParameterValue",
        "description": "This is a description of InvalidParameterValue"
      },
      {
        "value": 4003,
        "label": "InvalidJsonRequest",
        "description": "This is a description of InvalidJsonRequest"
      },
      {
        "value": 4004,
        "label": "InvalidJsonRequestCaseFormat",
        "description": "This is a description of InvalidJsonRequestCaseFormat"
      },
      {
        "value": 4010,
        "label": "InvalidCredentials",
        "description": "The credentials used to authenticate are invalid.  Either the username, password or both are incorrect."
      },
      {
        "value": 4011,
        "label": "InvalidSession",
        "description": "The session credentials supplied are invalid"
      },
      {
        "value": 5001,
        "label": "NoDataAvailable",
        "description": "There is no data available"
      }
    ]
  },
  "GetActiveStopLimitOrderResponseDTO": {
    "id": "GetActiveStopLimitOrderResponseDTO",
    "type": "object",
    "description": "Response containing the active stop limit order.",
    "properties": {
      "ActiveStopLimitOrder": {
        "$ref": "#.ApiActiveStopLimitOrderDTO",
        "description": "The active stop limit order. If it is null then the active stop limit order does not exist."
      }
    }
  },
  "GetMarketInformationResponseDTO": {
    "id": "GetMarketInformationResponseDTO",
    "type": "object",
    "description": "Response from am market information request.",
    "properties": {
      "MarketInformation": {
        "$ref": "#.MarketInformationDTO",
        "description": "The requested market information."
      }
    }
  },
  "SessionDeletionRequestDTO": {
    "id": "SessionDeletionRequestDTO",
    "type": "object",
    "description": "",
    "properties": {}
  },
  "CancelOrderRequestDTO": {
    "id": "CancelOrderRequestDTO",
    "type": "object",
    "description": "A cancel order request",
    "properties": {}
  },
  "LogOnRequestDTO": {
    "id": "LogOnRequestDTO",
    "type": "object",
    "description": "",
    "properties": {
      "UserName": {
        "type": "string",
        "description": "Username is case sensitive",
        "demoValue": "CC735158",
        "minLength": 6,
        "maxLength": 20
      },
      "Password": {
        "type": "string",
        "description": "Password is case sensitive",
        "demoValue": "password",
        "minLength": 6,
        "maxLength": 20
      }
    }
  },
  "ListSpreadMarketsResponseDTO": {
    "id": "ListSpreadMarketsResponseDTO",
    "type": "object",
    "description": "Contains the result of a ListSpreadMarkets query",
    "properties": {
      "Markets": {
        "type": "array",
        "items": {
          "$ref": "#.MarketDTO"
        },
        "description": "A list of Spread Betting markets"
      }
    }
  },
  "ApiWatchlistDisplayOrderSequenceRequestDTO": {
    "id": "ApiWatchlistDisplayOrderSequenceRequestDTO",
    "type": "object",
    "description": "Get market information for a list of markets.",
    "properties": {}
  },
  "ApiStopLimitResponseDTO": {
    "id": "ApiStopLimitResponseDTO",
    "type": "object",
    "description": "TODO",
    "extends": {
      "$ref": "#.ApiOrderResponseDTO"
    },
    "properties": {}
  },
  "ListOpenPositionsResponseDTO": {
    "id": "ListOpenPositionsResponseDTO",
    "type": "object",
    "description": "Contains the result of a ListOpenPositions query",
    "properties": {
      "OpenPositions": {
        "type": "array",
        "items": {
          "$ref": "#.ApiOpenPositionDTO"
        },
        "description": "A list of trades / open positions."
      }
    }
  },
  "ListMarketInformationSearchResponseDTO": {
    "id": "ListMarketInformationSearchResponseDTO",
    "type": "object",
    "description": "Response from am market information search request.",
    "properties": {
      "MarketInformation": {
        "type": "array",
        "items": {
          "$ref": "#.MarketInformationDTO"
        },
        "description": "The requested list of market information."
      }
    }
  },
  "ErrorResponseDTO": {
    "id": "ErrorResponseDTO",
    "type": "object",
    "description": "This is a description of ErrorResponseDTO",
    "properties": {
      "ErrorMessage": {
        "type": "string",
        "description": "This is a description of the ErrorMessage property",
        "demoValue": "Not authorized"
      },
      "ErrorCode": {
        "$ref": "#.ErrorCode",
        "description": "The error code"
      },
      "HttpStatusCode": {
        "type": "integer",
        "description": "HTTP status code",
        "demoValue": 401
      }
    }
  },
  "GetPriceTickResponseDTO": {
    "id": "GetPriceTickResponseDTO",
    "type": "object",
    "description": "The response from a request for Price Ticks",
    "properties": {
      "PriceTicks": {
        "type": "array",
        "items": {
          "$ref": "#.PriceTickDTO"
        },
        "description": "An array of price ticks, sorted in ascending order by PriceTick.TickDate"
      }
    }
  },
  "ListTradeHistoryResponseDTO": {
    "id": "ListTradeHistoryResponseDTO",
    "type": "object",
    "description": "Contains the result of a ListTradeHistory query",
    "properties": {
      "TradeHistory": {
        "type": "array",
        "items": {
          "$ref": "#.ApiTradeHistoryDTO"
        },
        "description": "A list of historical trades."
      }
    }
  }
}
