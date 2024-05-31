## **專案介紹**

在這個專案中，將使用 Spring Boot、RESTful API、OpenAPI Documentation 來實作一個用於追蹤車輛庫存的 Vehicles API。  
主要的 Vehicles API 會執行與車輛細節相關的 CRUD 操作，例如車輛的品牌、型號、顏色等，同時需要從其他微服務獲取有關位置和價格數據。

實作 Vehicles API 的 RESTful API，並可以通過基於 OpenAPI 文件進行查看和使用。  
將 **Pricing Service** 與 **Boogle Maps** 轉換成微服務 (Microservice)。

## **Starter Code**

包含 **Pricing Service** 與 **Boogle Maps** 原始碼，同學需要將這些 Service Packages 轉換成微服務，使用符合 RESTful 設計原則來撰寫 Vehicles API，並可以自動產生 API 文件進行查看和使用。

可以在 [這裡](https://github.com/udacity/nd035-C2-Web-Services-and-APIs-Exercises-and-Project-Starter) 下載 Starter Code。

## **專案結構**

### **位置服務**

資料夾 **`boogle-maps`**，這是一個模擬取得地圖座標的服務，給定經緯度會返回一個隨機地址，  
程式碼由 Starter Code 提供，同學將其轉換成為服務。

### **價格服務**

資料夾 **`pricing-service`**，這是一個取得車輛價格的服務，需要事先建立價格資料。  
程式碼由 Starter Code 提供，同學將其轉換成為服務。

### **Vehicles API 代碼**

資料夾 **`vehicles-api`**，本專案的主應用程式。  
提供車輛數據的 CRUD 操作，並與 **Boogle Maps** 和 **Pricing Service** 進行溝通。

**目錄結構**

**`api`**

- 負責處理 Client HTTP 請求
- 將請求參數轉換成 DTO

**`services`**

- 負責處理商業邏輯
- 將 Entity 轉換成 DTO
- 向 Repository 取得資料

**`clients`**

- 負責存取微服務 API
- 使用 [Spring Cloud OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/) 實作

**`configs`**

- 設定自動新增假資料
- 設定 Open API 文件

**`domian`**

- 每個 Entity 各自的 Data Access Layer
- 透過 JpaRepository 實作CRUD

---

<img width="600" src="https://github.com/benny-sun/CarSystem/assets/22260295/ba9c9bc9-a216-4647-8b43-6f49f2ff1276"/>

*使用 Swagger 瀏覽 API 文件*

### Eureka Server

資料夾 **`eureka`**，負責 Cloud Service 的服務註冊與發現，本專案將註冊 **`boogle-maps`**、**`pricing-service`**、**`vehicles-api`** 三個微服務。

<img width="600" src="https://github.com/benny-sun/CarSystem/assets/22260295/703c8c72-ec57-441c-bcae-c8c4fdc28ee3"/>

## Task Breakdown

<img width="300" src="https://github.com/benny-sun/CarSystem/assets/22260295/3f1855d6-c923-42dc-a6e3-08f927eecdbc"/>
